package stacksAndQueues;
/**
 * @desc FNV1_32_HASH算法
 * 
 * @author yuhuiping
 * @version v1.0 
 * @date 2017年3月23日上午11:22:40
 */
public class HashFunction {
	public static int  hash(String str){
	    final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i<str.length();i++ )
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash ;
        hash ^= hash >> 7;
        hash += hash ;
        hash ^= hash >> 17;
        hash += hash ;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
	}
}

