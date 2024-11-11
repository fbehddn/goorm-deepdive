package com.delivery.api.common.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * { "result"{ "result_code" : 200, "result_message" : "OK", "result_description" : "성공" }, "body":{ ... ... } }
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> {

    //result
    private Result result;

    //body
    @Valid
    private T body;

    public static <T> Api<T> OK(T data) {
        var api = new Api<T>();

        api.result = Result.Ok();
        api.body = data;
        return api;
    }
}
