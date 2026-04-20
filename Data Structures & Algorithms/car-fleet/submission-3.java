class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<int[]> stack = new Stack<>();
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < cars.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = cars.length - 1; i >= 0; i--) {
            int[] currCar = cars[i];
            if (stack.isEmpty() || compute(target, currCar) >
            compute(target, stack.peek())) {
                stack.push(currCar);
            }
        }
        return stack.size();
    }

    private double compute(int target, int[] car) {
        return (target - car[0]) / (double) car[1];
    }
}
