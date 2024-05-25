# 키친포스

## 퀵 스타트

```sh
cd docker
docker compose -p kitchenpos up -d
```

## 요구 사항

#### 메뉴그룹

- 등록
    - [X] 메뉴 그룹을 정상적으로 등록할 수 있다.
    - [X] 메뉴 그룹의 이름은 필수로 입력해야한다.
    - [X] 빈값만 입력하는 경우 등록할 수 없다.
- 전체 조회
    - [ ] 등록되어 있는 전체 메뉴 그룹을 조회할 수 있다.

#### 상품

- 등록
    - [X] 상품을 정상적으로 등록할 수 있다.
    - [X] 싱픔의 가격은 필수로 입력해야한다.
    - [X] 0원보다 적게 입력하는 경우 등록할 수 없다.
    - [X] 상품 이름을 입력하지 않는 경우 등록할 수 없다.
    - [X] 상품 이름에 욕설이 포함되어있는 경우 등록할 수 없다.
- 가격 변경
    - [X] 상품 가격은 변경할 수 있다.
    - [X] 변경 가격을 입력하지 않는 경우 변경할 수 없다.
    - [X] 0원보다 적게 입력하는 경우 변경할 수 없다.
    - [X] 등록되어 있지 않은 상품 정보인 경우 변경할 수 없다.
    - [X] 금액 변경으로 인해 해당 상품이 포함된 메뉴의 가격이 메뉴 구성 전체 상품의 총 금액보다 비싸지는 경우 메뉴가 숨겨진다.
- 전체 조회
    - [ ] 등록되어 있는 전체 상품을 조회할 수 있다.

#### 주문테이블

- 테이블정보에는 테이블이름, 손님 수, 착석여부가 있다.
- 테이블정보 등록
    - [X] 테이블정보를 정상으로 등록할 수 있다.
    - [X] 테이블 이름은 필수로 입력해야한다.
    - [X] 최초 등록시 테이블의 손님 수와 착석여부 상태는 모두 빈 좌석으로 저장된다. (손님수 0명, 미착석 상태)
- 테이블 착석여부 변경
    - [X] 테이블의 착석여부를 변경할 수 있다. -> (TODO) 착성중/미착석 분리
    - [X] 등록된 테이블정보가 아닌 경우 처리가 불가능하다.
    - 착석중
    - [X] 착석여부 상태가 착석으로 변경된다.
    - 미착석
    - [X] 테이블에 주문된적이 있고 주문상태가 COMPLETED 가 아닌 경우 처리가 불가능하다.
    - [X] 손님 수 정보와 착석여부 상태가 미착석으로 변경된다.
- 손님수 변경
    - [X] 손님수를 변경할 수 있다.
    - [X] 변경하려는 손님 수가 0명보다 적은 경우 변경할 수 없다.
    - [X] 등록된 테이블 정보가 아닌 경우 손님 수를 변경할 수 없다.
    - [X] 테이블이 손님 착성중 상태가 아닌 경우 손님 수를 변경할 수 없다.
- 전체 조회
    - [ ] 등록된 모든 테이블 정보를 조회할 수 있다.

#### 메뉴

- 메뉴 정보에는 이름, 가격, 그룹정보, 노출여부, 메뉴상품이 있다.
- 신규 등록
    - [ ] 메뉴를 등록할 수 있다.
    - [X] 메뉴 이름
        - [X] 메뉴 이름은 필수로 입력해야한다.
        - [X] 메뉴 이름에 욕설이 포함되어있는 경우 등록할 수 없다.
    - [X] 메뉴 금액
        - [X] 메뉴마다 금액정보는 필수로 입력해야한다.
        - [X] 0원보다 적은 금액을 입력하는 경우 메뉴를 등록할 수 없다.
    - [X] 메뉴그룹정보
        - [X] 등록되어있는 메뉴 그룹 정보가 필수로 입력해야한다.
    - [X] 메뉴상품
        - [X] 메뉴를 구성하는 상품정보를 필수로 입력해야한다.
        - [X] 상품정보는 하나 이상 입력이 가능하다.
        - [X] 등록되어있지 않은 상품정보를 입력하는 경우 메뉴를 등록할 수 없다.
        - [X] 상품정보의 수량이 0개보다 작은 경우 메뉴를 등록할 수 없다.
        - [X] 상품정보의 총 합계 금액보다 메뉴의 가격이 비싼 경우 등록할 수 없다.
- 금액 변경
    - [X] 메뉴는 금액을 변경할 수 있다.
    - [X] 변경할 금액 정보가 없는 경우 변경이 불가하다.
    - [X] 0원보다 작은 금액을 입력하는 경우 변경이 불가하다.
    - [X] 변경하려고 하는 메뉴 정보가 없는 경우 변경이 불가하다.
    - [X] 변경금액이 메뉴 상품의 총 합계 금액보다 비싼 경우 변경할 수 없다.
- 노출여부 변경
    - [X] 메뉴는 노출되도록 변경할 수 있다.
    - [X] 메뉴는 숨길 수 있다.
    - 노출로 변경
        - [X] 등록된적 없는 메뉴는 노출되도록 변경할 수 없다.
        - [X] 노출하려는 메뉴의 금액이 상품정보의 총 합계 금액보다 높은 경우 변경할 수 없다.
    - 미노출로 변경
        - [X] 등록된적 없는 메뉴는 노출되지 않도록 변경할 수 없다.
- 전체 조회
    - [ ] 등록되어 있는 모든 메뉴를 조회할 수 있다.

#### 주문

- 주문접수 (WAITING)
    - 주문접수를 받을 때에는 주문타입, 주문테이블, 메뉴정보가 있다.
    - 주문타입
        - [X] 주문타입 정보가 없는 경우 주문을 받을 수 없다.
    - 메뉴
        - [X] 하나의 주문에 여러개 메뉴 주문이 가능하다.
        - [X] 메뉴를 하나도 선택하지 않은 경우 주문할 수 없다.
        - [X] 주문한 메뉴들 중에 하나라도 등록되어 있지 않은 메뉴가 포함되어 있으면 주문할 수 없다.
        - [X] 미노출된 메뉴가 포함되어있는 경우 주문할 수 없다.
        - [X] 주문한 메뉴의 금액과 등록된 메뉴 금액이 다른 경우 주문할 수 없다.
        - [X] 주문이 접수완료된 경우 주문상태가 대기중(WAITING)이 된다.

    - 배달 주문
        - [X] 배달 주문을 접수받을 수 있다.
        - [X] 배달 주소 정보는 필수로 입력해야한다.
        - [X] 주문한 메뉴 중 0개보다 작은 메뉴가 있는 경우 주문할 수 없다.

    - 매장 주문
        - [X] 매장 주문을 접수받을 수 있다.
        - [X] 등록된 테이블정보가 아닌 경우 접수가 불가하다.
        - [X] 손님이 착석중이 아닌 테이블로 접수가 들어온 경우 접수가 불가능하다.
        - [X] 0개보다 적게 취소주문이 가능하다. (취소는 1개씩 가능)

    - 포장 주문
        - [X] 포장 주문을 접수받을 수 있다.
        - [X] 주문한 메뉴 중 0개보다 작은 메뉴가 있는 경우 주문할 수 없다.

- 주문수락 (ACCEPTED)
    - [X] 접수된적 없는 주문인 경우 수락이 불가능하다.
    - [X] 주문상태가 대기중이 아닌 경우 처리가 불가능하다.
    - 배달 주문
        - [X] 배달주문인 경우 배달라이더에게 배달 요청이 완료되어야 수락된다.
    - [X] 주문수락이 완료된 경우 주문상태가 대기중 에서 수락(ACCEPTED) 상태로 변경된다.
- 음식 제공 완료 (SERVED)
    - [X] 접수된적 없는 주문인 경우 처리할 수 없다.
    - [X] 주문상태가 수락상태가 아닌 경우 처리할 수 없다.
    - [X] 처리가 되는경우 주문상태가 수락에서 에서 음식제공 완료(SERVED) 로 변경된다.
- 배달 중 (DELIVERING)
    - [X] 배달주문(DELIVERY)이 아닌 경우 배달을 시작할 수 없다.
    - [X] 음식이 아직 제공되지 않은 경우(SERVED) 배달을 시작할 수 없다.
    - [X] 접수된적 없는 주문인 경우 배달을 시작할 수 없다.
    - [X] 배달이 시작되면 주문 상태는 음식 제공에서 배달중(DELIVERING) 으로 변경된다.
- 배달 완료 (DELIVERED)
    - [X] 접수된적 없는 주문인 경우 처리할 수 없다.
    - [X] 주문상태가 배달 중이 아니면 배달완료로 처리할 수 없다.
    - [X] 배달완료상태가 되는 경우 배달 중 에서 배달 완료(DELIVERED) 로 변경된다.
- 주문 처리 완료 (COMPLETED)
    - [X] 완료 상태가 되면 주문 처리 완료(COMPLETED) 가 된다.
    - [X] 접수된적 없는 주문인 경우 처리할 수 없다.
    - 배달주문
        - [X] 배달주문인데 배달 완료 상태가 아니면 처리할 수 없다.
    - 포장/매장주문
        - [X] 포장주문이거나 매장식사인 경우 음식 제공 완료 상태가 아니면 처리할 수 없다.
    - 매장주문
        - [X] 메징식사인 경우 주문상태가 완료가 되면 주문테이블의 손님 수와 착석여부 상태를 빈 좌석으로 정리한다. (손님 수 0명, 미착석 상태로 변경)
- 전체 조회
    - [ ] 접수되었던 모든 주문 정보를 조회할 수 있다.

## TODO

- [ ] repository fake 객체로 리팩토링
- [ ] controller ATDD 작성

## 용어 사전

### 공통

| 한글명 | 영문명        | 설명                                              |
|-----|------------|-------------------------------------------------|
| 고객  | user       | - 키친포스 서비스 이용자의 총칭이다. <br> - 손님/사장님으로 구분할 수 있다. |
| 손님  | customer   | - 주문을 하는 모든 키친포스 고객을 뜻한다.                       |
| 사장님 | manager    | - 키친포스 내 매장의 메뉴를 관리하는 고객을 뜻한다.                  |
| 매장  | restaurant | - 손님이 방문하여 매장 주문을 할 수 있는 장소                     |
| 비속어 | slang      | - 욕설과 외설성을 포함하는 단어. (은어를 포함하지 않음)               |
| 수량  | quantity   | - 수량을 의미하는 단어                                   |
| 이름  | name       | - 이름을 표현하는 단어                                   |

### 상품

| 한글명   | 영문명           | 설명                                                                                                            |
|-------|---------------|---------------------------------------------------------------------------------------------------------------|
| 상품    | product       | - 메뉴의 단위 요리를 표현한다. (음식의 재료를 표현하는 것은 아님). <br> - 사장님인 경우에 등록이 가능하다.                                            |
| 상품 이름 | product name  | - 상품을 표현하는 이름으로, 등록할 때 필요하다. (단, 비속어 포함 불가)                                                                   |
| 상품 가격 | product price | - 상품 가격으로, 0원 이상 등록이 되어야 한다. <br> - 가격은 상품 등록 후 변경이 가능하다. (단, 메뉴에 속한 경우 메뉴 가격이 메뉴에 속한 상품 금액의 합보다 크면 메뉴가 숨겨짐.) |

### 메뉴 그룹

| 한글명   | 영문명        | 설명                    |
|-------|------------|-----------------------|
| 메뉴 그룹 | menu group | - 메뉴들을 묶어서 표현하는 단위이다. |

### 메뉴

| 한글명      | 영문명                 | 설명                                                                                                 |
|----------|---------------------|----------------------------------------------------------------------------------------------------|
| 메뉴       | menu                | - 사장님이 등록 후 손님이 주문할 수 있는 단위이며, 한 개 이상 상품으로 구성된다. <br> - 한 개 이상 상품으로 구성된다. <br> - 한 개의 메뉴 그룹에 속해있다. |
| 메뉴 가격    | menu price          | - 사장님이 등록할 수 있는 메뉴의 가격이다.<br> - 메뉴의 가격이 메뉴에 속한 상품 금액의 합보다 높을 경우 메뉴를 노출할 수 없다.                      |
| 메뉴 노출 상태 | menu display status | - 메뉴의 노출 여부를 의미하며, 노출되거나 숨겨질 수 있다.                                                                 |
| 노출된 메뉴   | displayed menu      | - 손님이 메뉴에 대한 정보를 볼 수 있다는 것을 의미한다.                                                                  |
| 숨겨진 메뉴   | undisplayed menu    | - 손님이 메뉴에 대한 정보를 볼 수 없다는 것을 의미한다.                                                                  |

### 메뉴 상품

| 한글명   | 영문명          | 설명                                 |
|-------|--------------|------------------------------------|
| 메뉴 상품 | menu product | - 메뉴를 구성하는 상품으로, 하나의 상품과 개수로 구성된다. |

### 주문테이블

| 한글명          | 영문명              | 설명                                                                   |
|--------------|------------------|----------------------------------------------------------------------|
| 주문 테이블       | order table      | - 매장에서 관리되는 테이블로 매장 식사 손님용. <br> - 매장 식사 손님이 모든 식사를 마치는 경우 테이블을 치운다. |
| 주문 테이블 착석 여부 | occupied         | - 손님의 착석 여부를 표현한다.                                                   |
| 착석 테이블       | occupying table  | - 손님이 앉아있는 테이블을 표현한다.                                                |      |
| 빈 테이블        | cleared table    | - 테이블을 치운 상태를 빈 테이블이라고 표현한다.                                         |
| 손님 수         | number of guests | - 매장 내 한 테이블에 있는 손님의 수                                               |

### 주문

| 한글명   | 영문명             | 설명                                                                                                                  |
|-------|-----------------|---------------------------------------------------------------------------------------------------------------------|
| 주문    | order           | - 손님이 메뉴를 시키는 것으로, 배달 주문, 포장 주문, 매장 주문이 가능하다.                                                                       |
| 주문항목  | order line item | - 주문을 구성하는 메뉴로, 하나의 메뉴와 개수, 가격으로 구성된다.                                                                              |
| 주문 상태 | order status    | - 주문의 상태를 말하며, 주문 접수(WAITING), 주문 수락(ACCEPTED), 서빙 완료(SERVED), 배달 중(DELIVERING), 배달 완료(DELIVERED), 주문 완료(COMPLETED) |

#### 배달주문

| 한글명         | 영문명                      | 설명                                                              |
|-------------|--------------------------|-----------------------------------------------------------------|
| 배달 주문       | delivery order           | - 손님이 입력한 배달 주소로 배달 대행사를 통해 배달해주는 주문.                           |
| 배달 주소       | delivery address         | - 배달 주문한 손님이 설정한 배달 목적지.                                        |
| 배달 대행사      | delivery rider           | - 배달 주소로 메뉴를 전달해주는 대행사. <br> - 배달 대행사 수락이 안되는 경우, 배달 수락이 불가능하다. |
| 배달 주문 접수    | delivery order waiting   | - 주문을 접수한 상태를 말한다.                                              |
| 배달 주문 수락    | delivery order accepted  | - 주문을 수락해 배달 대행사 요청이 완료된 상태를 말한다.                               |
| 배달 주문 서빙 완료 | delivery order served    | - 음식 조리 및 포장까지 완료된 상태를 말한다.                                     |
| 배달 중        | delivering               | - 배달을 시작한 상태를 말한다.                                              |
| 배달 완료       | delivered                | - 배달이 완료된 상태를 말한다.                                              |
| 배달 주문 완료    | delivery order completed | - 주문이 완료된 상태를 말한다.                                              |

#### 포장주문

| 한글명      | 영문명                     | 설명                          |
|----------|-------------------------|-----------------------------|
| 포장 주문    | takeout order           | - 손님이 매장에 방문하여 포장해가는 주문.    |
| 포장 주문 접수 | takeout order waiting   | - 주문을 접수한 상태를 말한다.          |
| 포장 주문 수락 | takeout order accepted  | - 주문을 수락한 상태를 말한다.          |
| 포장 서빙 완료 | takeout order served    | - 음식 조리 및 포장까지 완료된 상태를 말한다. |
| 포장 주문 완료 | takeout order completed | - 주문이 완료된 상태를 말한다.          |

#### 매장주문

| 한글명      | 영문명                    | 설명                                                                                                       |
|----------|------------------------|----------------------------------------------------------------------------------------------------------|
| 매장 주문    | eat-in order           | - 손님이 매장에 방문하여 주문 테이블에 앉아 식사하는 주문. <br> - 비어있는 주문 테이블이 없는 경우 주문이 불가능하다. <br> - - 주문 항목의 수량이 0개 미만일 수 있다. |
| 매장 주문 접수 | eat-in order waiting   | - 주문을 접수한 상태를 말한다.                                                                                       |
| 매장 주문 수락 | eat-in order accepted  | - 주문을 수락한 상태를 말한다.                                                                                       |
| 매장 서빙 완료 | eat-in order served    | - 음식 조리가 끝나 손님에게 전달할 수 있는 상태를 말한다.                                                                       |
| 매장 주문 완료 | eat-in order completed | - 주문이 완료된 상태를 말한다.                                                                                       |

## 모델링

### 상품

- `Product` 는 식별자, `ProductName`, `ProductPrice` 을 가진다.

### 메뉴 그룹

- `MenuGroup` 은 식별자, `MenuGroupName` 을 가진다.

### 메뉴

- `Menu` 는 식별자, `MenuName`, `MenuPrice`, `MenuGroup`, `MenuDisplayStatus`, `MenuProducts` 를 가진다.
- `Menu`에서 `MenuProducts`를 생성한다.
- `Menu`에서 `MenuDisplayStatus` 를 변경한다.
- `Menu`에서 `MenuProduct` 가격의 총 `Price`을 계산한다.

### 메뉴 상품

- `MenuProduct` 는 `Product`, `Quantity` 을 가진다.
- `MenuProduct` 에서 `Product` 의 총 `Price` 을 계산한다.

### 주문 테이블

- `OrderTable` 은 식별자, `OrderTableName`, `NumberOfGuests`, `Occupied` 를 가진다.
- `OrderTable` 에서 `Occupied`를 변경한다.

### 배달 주문

- `Order` 는 `OrderType` 중 `DELIVERY_ORDER` 를 가진다.
- `Order` 는 식별자, `OrderStatus`, 주문 일시, `DeliveryAddress`, `OrderLineItems` 을 가진다.
- `Order` 에서 `OrderLineItems` 를 생성한다.
- `OrderLineItems`은 선택한 `Menu`와 `Quantity`과 총 `Price`을 가진다.
- `Order` 에서 `OrderStatus` 를 변경한다.
- `OrderStatus` 는 `Waiting` → `Accepted` → `Served` → `Delivering` → `Delivered` → `Completed` 를 가진다.
  ```mermaid
  ---
  title: Delivery OrderStatus
  ---
  flowchart LR
    A[Waiting] --> D(Accepted)
    D --> E(Served)
    E --> F(Delivering)
    F --> G(Delivered)
    G --> H[Completed]
  ```

### 포장 주문

- `Order` 는 `OrderType` 중 `TAKEOUT` 를 가진다.
- `Order` 는 식별자, `OrderStatus`, 주문 일시, `OrderLineItems` 을 가진다.
- `Order` 에서 `OrderLineItems` 를 생성한다.
- `OrderLineItems`은 선택한 `Menu`와 `Quantity` 과 총 `Price` 을 가진다.
- `Order` 에서 `OrderStatus` 를 변경한다.
- `OrderStatus` 는 `Waiting` → `Accepted` → `Served` → `Completed` 를 가진다.
  ```mermaid
  ---
  title: Takeout OrderStatus
  ---
  flowchart LR
    A[Waiting] --> D(Accepted)
    D --> E(Served)
    E --> H[Completed]
  ```

### 매장 주문

- `Order` 는 `OrderType` 중 `EAT_IN` 를 가진다.
- `Order` 는 식별자, `OrderStatus`, 주문 일시, `OrderLineItems`, `OrderTable`을 가진다.
- `Order` 에서 `OrderLineItems` 를 생성한다.
- `OrderLineItems`은 선택한 `Menu`와 `Quantity` 과 총 `Price` 을 가진다.
- `Order` 에서 `OrderStatus` 를 변경한다.
- `OrderStatus` 는 `Waiting` → `Accepted` → `Served` →  `Completed` 를 가진다.
  ```mermaid
  ---
  title: EatIn OrderStatus
  ---
  flowchart LR
    A[Waiting] --> D(Accepted)
    D --> E(Served)
    E --> H[Completed]
  ```

### 기타

#### 주문 등록 정책

- `배달 주문`: `메뉴`가 `노출된 메뉴`이고 `배달 주소`가 있어야 `메뉴`가 0개 이상이어야 등록이 가능하다.
- `매장 주문`: `메뉴`가 `노출된 메뉴`이고 `주문 테이블`이 있어야 등록이 가능하다.
- `포장 주문`: `메뉴`가 `노출된 메뉴`이고 `메뉴`가 0개 이상이어야 등록이 가능하다.

#### 주문상태 변경 정책

- `주문`의 유형별로 정의된 `주문상태`의 순서대로만 변경이 가능하다.

