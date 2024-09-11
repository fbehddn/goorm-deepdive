package practice.restapi_ex.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import practice.restapi_ex.dto.ItemDto;
import practice.restapi_ex.dto.ResponseDto;
import practice.restapi_ex.dto.UserDto;
import practice.restapi_ex.service.RestExService;

@RestController
@Slf4j
public class RestExController {
    private final RestExService restExService;


    public RestExController(RestExService restExService) {
        this.restExService = restExService;
    }

    @GetMapping("/test")
    public String test() {
        log.info("test");
        return "{}";
    }

    @GetMapping("/test2")
    public String test2() {
        log.info("test2");
        return "test2";
    }

    // http://localhost:8080/param?name=Spring
    @GetMapping("/param")
    public String testRequestParam(@RequestParam String name) {
        log.info("RequestParam: " + name);
        return "Hello, " + name + "!";
    }

    // http://localhost:8080/path/Spring
    @GetMapping("/path/{name}")
    public String testPathVariable(@PathVariable String name) {
        log.info("PathVariable: " + name);
        return "Path variable: " + name;
    }

    // @RequestBody: 사용 데이터를 객체로 바인딩
    @PostMapping("/body")
    public String testRequestBody(@RequestBody UserDto userDto) {
        log.info("RequestBody: " + userDto);
        return "RequestBody: " + userDto;
    }

    @GetMapping("/item")
    public ItemDto getItem(@RequestParam("id") String id) {
        ItemDto res = restExService.getItem(id);
        return res;
    }

    @PostMapping("/item")
    public ResponseDto testResponseBody(@RequestBody ItemDto item) {
        log.info("ResponseBody: " + item);

        boolean b = restExService.registerItem(item);
        if (b) {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("ok");
            return responseDto;
        }

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");
        return responseDto;
    }
}
