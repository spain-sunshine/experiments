public class BitOperator{
    public static void main(String[] args){
        System.out.println(2&3);
        System.out.println(2|3);
        System.out.println(2^3);
        System.out.println(~3);
        // 2,3,1,-4
        /*第四个，对3按位取反
        00000011
        11111100 取反后的结果
        在Java中，整数默认使用二进制的补码形式来表示。
        10000011  11111100的反码
        10000100  11111100的补码，也就是-4
        */
        System.out.println(4>>2);
        System.out.println(4<<2);
        System.out.println(-4>>2);
        System.out.println(-4<<2);        

    }
}
