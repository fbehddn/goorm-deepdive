import React from "react";
import Welcome from "./Components/Welcome";
import Clock from "./Components/Clock";
import Counter from "./Components/Counter";

function App(_props) {
  return (
    <div>
      <h1>React 기본 예제</h1>
      <Welcome />
      <Clock />
      <Counter />
    </div>
  );
}

export default App;
