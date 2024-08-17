class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        for (String route : routes) {
            char direction = route.charAt(0);
            int steps = route.charAt(2) - '0';

            int newX = x;
            int newY = y;

            switch (direction) {
                case 'E':
                    newY += steps;
                    break;
                case 'W':
                    newY -= steps;
                    break;
                case 'N':
                    newX -= steps;
                    break;
                case 'S':
                    newX += steps;
                    break;
            }

            boolean isBlocked = false;
            int tempX = x;
            int tempY = y;

            for (int i = 1; i <= steps; i++) {
                switch (direction) {
                    case 'E':
                        tempY++;
                        break;
                    case 'W':
                        tempY--;
                        break;
                    case 'N':
                        tempX--;
                        break;
                    case 'S':
                        tempX++;
                        break;
                }

                if (tempX < 0 || tempX >= park.length || tempY < 0 || tempY >= park[0].length() ||park[tempX].charAt(tempY) == 'X'){
                    isBlocked = true;
                    break;
                }

            }

            if (!isBlocked) {
                x = newX;
                y = newY;
            }
        }

        int[] answer = { x, y };
        return answer;
    }

}