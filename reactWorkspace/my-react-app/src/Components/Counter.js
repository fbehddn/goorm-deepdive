import React, { useState } from "react";

// 함수형 컴포넌트 : rsf 스니펫
// 상태 관리: useState() 사용
// 버튼 클릭해서 클릭 수 증가
function Counter(props) {
  const [count, setCount] = useState(0);

  return (
    <div>
      <h3>버튼을 {count}번 클릭했습니다.</h3>
      <button onClick={() => setCount(count + 1)}>클릭</button>
    </div>
  );
}

export default Counter;
