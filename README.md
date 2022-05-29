## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

## 학습내용


## Todo List
Feat CardNumber 도메인 클래스 작성 (with 테스트 케이스)

- CardNumber에서 ace일 시 1, 11의 값을 반환한다. (21에 가장 근접한 값으로 만들기 위해)
  int value;
  CardType jack, queen, king, ace, none;

~~Feat PlayingCard 클래스 구현  (with 테스트 케이스)~~

Feat PlayingCards 일급컬렉션 구현  (with 테스트 케이스)

- 카드합이 21인 경우 블랙잭(isBlackJack)
- 카드 숫자 총합 반환 (sumCardNumber)
- 카드 추가 기능


Feat Dealer 클래스 구현  (with 테스트 케이스)

- 딜러는 처음에 받은 2장의 합계가 16이하면 반드시 1장의 카드를 추가로 받아야 하고 17점 이상이면 추가로 받을 수 없다.
- 딜러가 21을 초과하면 그 시점까지 남아있던 플레이어들은 가지고 있는 패에 상관없이 승리하여 베팅 금액을 받는다.


Feat Player 기능구현  (with 테스트 케이스)

- 카드를 더 받을 지 안받을지 결정한다.
- 추가로 뽑아 21을 초과 시 배팅 금액을 모두 잃게 된다.
- 처음받은 2장의 카드합이 21인 경우 배팅금액의 1.5배 받는다. (단 딜러가 블랙잭이 아닌경우! 딜러가 블랙잭이면 배팅한 금액만 돌려받는다.)

Feat CardMachine 기능 구현  (with 테스트 케이스)
- 랜덤으로 카드를 반환한다.
- 한번이라도 반환한 카드는 재사용 불가능하다.