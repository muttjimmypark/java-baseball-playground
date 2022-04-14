### 구현할 기능 목록
1. Numbers
    1. verifyNumbers : 1~9 사이의 서로 다른 수로 이루어진 3자리의 수가 되도록, 입력받은 숫자를 검증하여 boolean으로 응답하는 기능
    2. makeComputerNumbers : 컴퓨터 측 랜덤 숫자를 생성하는 기능. verifiyNumbers에서 false 받으면 재생성
####
2. Compare : 3자리 숫자 2개(컴퓨터, 플레이어)를 입력받아 생성되며, 볼 판정값과 스트라이크 판정값을 확보할 수 있는 클래스
    1. existCount : 플레이어 측 숫자 3개 중, 컴퓨터 측에는 얼마나 들어있는지 세어보는 기능
    2. strikeCount : 같은 자리에 같은 숫자가 들어있는 경우를 세어보는 기능
    3. return : (볼 = existCount - strikeCount), (스트라이크  = strikeCount )
    4. 변수 ball과 strike의 getter
####
3. UserInterface
    1. scanPlayerNumbers : 플레이어 측 숫자를 입력받는 기능. [1-2]에서 verify하여 false를 받으면 재입력 요구
    2. printBSMessage : 볼-스트라이크 값을 전달받아, 판정 결과를 String으로 구성 (볼, 스트라이크, 낫싱)
    3. endGameOrNew : 게임 종료 메시지와 새 게임 시작여부
####
4. Application : main 실행부
    1. makeComputerNumbers -> computerNumbers
    2. 3 스트라이크가 나올때 까지 아래 내용을 반복
        1. scanPlayerNumbers -> playerNumbers
        2. Compare(computerNumbers, playerNumbers)
        3. printBSMessage(getBall, getStrike)
    3. 3 스트라이크가 나오면 endGameOrNew를 통해, 종료 또는 새 게임 시작