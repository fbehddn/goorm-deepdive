import React, { Component } from "react";

//클래스형 컴포넌트 사용 : rcc 스니펫 사용
// 상태는 this.statc, this.setState 사용
// 생명 주기 메서드 사용
// 매 초 시계를 업데이트

class Clock extends Component {
  constructor(props) {
    super(props);
    this.state = { date: new Date(), count: 0 };
  }

  componentDidMount() {
    this.timerId = setInterval(() => this.tick(), 1000);
  }
  componentWillUnmount() {
    clearInterval(this.timerId);
  }

  tick() {
    this.setState({
      date: new Date(),
    });
  }

  render() {
    return (
      <div>
        <h2>현재 시간 : {this.state.date.toLocaleTimeString()}</h2>
      </div>
    );
  }
}

export default Clock;
