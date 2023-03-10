# Spring Boot Sample Code using web3j and ChainZ Framework

## Description
Storage Contract를 web3j와 ChainZ Framework를 활용해 배포하고 Smart Contract 함수를 호출하는 예제입니다.

참고) Storage Contract
```javascript
pragma solidity >=0.8.2 <0.9.0;

contract Storage {
    uint256 number;
    
    function store(uint256 num) public {
        number = num;
    }

    function retrieve() public view returns (uint256){
        return number;
    }
}
```
## Guide
1. Swagger UI 경로는 http://localhost:8080/swagger-ui/index.html 입니다. Sample API 목록과 입력 파라미터는 Swagger UI를 통해 확인해주세요.
2. createAccount API로 Smart Contract 배포에 사용할 계정을 생성합니다.
3. deployContract API로 Storage Contract를 배포합니다. 다른 Contract를 배포하려면 ChainzFrameworkServiceImpl의 bytecode를 배포하려는 Contract의 bytecode로 변경하세요. 
4. store API로 Contract의 State를 변경하는 store Transaction을 요청합니다. Transaction이 정상적으로 처리되었는지 확인하는 방법은 아래 3가지 방법이 있습니다.
   * getTransactionResult API로 Transaction 처리결과를 조회 (Polling 방식)
   * RabbitMQ로 처리 결과를 Subcribe (연결 방법은 API 문서 참고)
   * State를 조회하여 상태변경이 제대로 처리되었는지 확인
```java
Function function = new Function(
    "store", // 호출할 함수명
    Arrays.asList(new Uint256(1)), // 입력 Parameter와 Type
    new ArrayList() // 출력 Parameter와 Type
);
String data = FunctionEncoder.encode(function);
```
5. retrieve API로 Contract의 State를 조회합니다.
```java
Function function = new Function(
    "retrieve", // 호출할 함수명
    new ArrayList(), // 입력 Parameter와 Type
    Arrays.asList(new TypeReference<Uint256>() {}) // 출력 Parameter의 Type
);
String data = FunctionEncoder.encode(function);
```
