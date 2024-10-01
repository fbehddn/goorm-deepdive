import React, { useState } from "react";

function RandomNumber() {
  // useState를 사용하여 랜덤 숫자를 상태로 관리
  const [number, setNumber] = useState(0);

  // 랜덤 숫자를 생성하는 함수
  const generateRandomNumber = () => {
    const randomNum = Math.floor(Math.random() * 100) + 1;
    setNumber(randomNum);
  };

  return (
    <div style={styles.container}>
      <h1>RandomNumber Generator</h1>
      <p style={styles.number}>{number}</p>
      <button style={styles.button} onClick={generateRandomNumber}>
        숫자 생성
      </button>
    </div>
  );
}

const styles = {
  container: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "center",
    height: "100vh",
  },
  number: {
    fontSize: "4rem",
    margin: "30px 0",
  },
  button: {
    padding: "10px 20px",
    fontSize: "2rem",
    backgroundColor: "#4CAF",
    color: "white",
    border: "none",
    borderRadius: "10px",
    cursor: "pointer",
  },
};

export default RandomNumber;
