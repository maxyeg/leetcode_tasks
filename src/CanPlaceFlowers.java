public class CanPlaceFlowers {
    public static void main(String[] args) {
        CanPlaceFlowers cpf = new CanPlaceFlowers();
//        Utils.output(cpf.canPlaceFlowers(new int[]{1,0,0,0,1},1));
//        Utils.output(cpf.canPlaceFlowers(new int[]{1,0,0,0,1},2));
//        Utils.output(cpf.canPlaceFlowers(new int[]{1,0,0,0,1,0,0},2));
//        Utils.output(cpf.canPlaceFlowers(new int[]{0},1));
        Utils.output(cpf.canPlaceFlowers(new int[]{0,0,1,0,0},1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            return flowerbed[0] + n <= 1;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) return true;
            if (flowerbed[i] == 0) {
                if ((i == 0 && flowerbed[i+1] == 0) || (i == flowerbed.length - 1 && flowerbed[i-1] == 0)) {
                    flowerbed[i] = 1;
                    --n;
                } else if (i > 0 && flowerbed[i-1] == 0 && i < flowerbed.length - 1 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    --n;
                }
            }
        }
        return n == 0;
    }
}
