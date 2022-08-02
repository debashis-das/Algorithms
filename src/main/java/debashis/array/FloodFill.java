package debashis.array;

import java.util.*;

public class FloodFill {

    class Cordinate {
        int x;
        int y;
        Cordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        int[][] screen = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x = 0;
        int y = 0;
        int newColor = 3;
        FloodFill floodFill = new FloodFill();
        Arrays.stream(floodFill.fill(screen, x, y, newColor)).forEach(h -> {
            Arrays.stream(h).forEach(v -> System.out.print(v + " "));
            System.out.println();
        });
    }

    private int[][] fill(int[][] screen, int x, int y, int newColor) {
        Queue<Cordinate> queue = new LinkedList<>();
        Cordinate cordinate = new Cordinate(x,y);
        queue.offer(cordinate);
        List<Cordinate> neighbors = neighboringCordinates();
        int oldColor = screen[x][y];
        while(!queue.isEmpty()){
            Cordinate currentCordinate = queue.poll();
            for(Cordinate tempCordinate : neighbors){
                int nx = currentCordinate.x + tempCordinate.x;
                int ny = currentCordinate.y + tempCordinate.y;
                if(nx >= 0 && ny >=0 && nx < screen.length && ny < screen[0].length && screen[nx][ny] == oldColor && screen[nx][ny] != newColor) {
                    Cordinate newCordinate = new Cordinate(nx, ny);
                    queue.offer(newCordinate);
                }
            }
            screen[currentCordinate.x][currentCordinate.y] = newColor;
        }
        return screen;
    }

    private List<Cordinate> neighboringCordinates(){
        List<Cordinate> neighbors = new ArrayList<>();
        neighbors.add(new Cordinate(-1,-1));
        neighbors.add(new Cordinate(-1,0));
        neighbors.add(new Cordinate(-1,1));
        neighbors.add(new Cordinate(0,1));
        neighbors.add(new Cordinate(1,1));
        neighbors.add(new Cordinate(1,0));
        neighbors.add(new Cordinate(1,-1));
        neighbors.add(new Cordinate(0,-1));
        return neighbors;
    }
}
