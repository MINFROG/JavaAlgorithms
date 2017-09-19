package sort;

import java.util.Arrays;

/**
 * @desc TODO添加描述
 * 
 * @author yuhuiping
 * @version v1.0 
 * @date 2017年4月11日下午3:57:51
 */
public class MergeSort1 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 10, 8, 4, 80, 13, 1, 3, 11 };
		int b[] = { 9, 0, 3, 2, 6, 15, 20, 60 };
		int c[] = new int[a.length];
		mergeSort_srt(a,0,a.length,c);
		//int mid = (0 + a.length) /2;
		//mergeArray(a,0,mid,a.length,c);
		//mergeSort(a,a.length,b,b.length, c);
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(a));
		//mergeSort_srt(array, 0, array.length - 1);
	}
	
	//合并有序数列
	public static void mergeSort(int[] a ,int n, int[] b ,int m, int[] c){
		int i = 0, j= 0  , k = 0 ;
		while(i<n && j < m){
			if(a[i] < b[j]){
				c[k++] = a[i++];
			}else {
				c[k++] = b[j++];
			}
		}
		while(i<n){
			c[k++] = a[i++];
		}
		while(j<m){
			c[k++] = b[j++];
		}
	}
	//排序
	public static void mergeArray(int a[],int first,int mid,int last,int temp[]){
		int i = first ;
		int j = mid+1;
		int n = mid;
		int m = last;
		int k = 0 ;
		while(i< n && j < m){
			if(a[i] < a[j]){
				temp[k++] = a[i++];
			}else{
				temp[k++] = a[j++];
			}
		}
		while(i<n){
			temp[k++] = a[i++];
		}
		while(j<m){
			temp[k++] = a[j++];
		}
		//给a[]赋值
		for( i = first ; i<k ;i++){
			a[first+i] = temp[i];
		}
	}

	public static void mergeSort_srt(int[] array, int first, int last,int temp[]) {
		if(first >= last) return  ;
		int mid = (first + last)/2;
		mergeSort_srt(array,first,mid,temp);
		mergeSort_srt(array,mid+1,last,temp);
		mergeArray(array,first,mid,last,temp);
	}
	
}

