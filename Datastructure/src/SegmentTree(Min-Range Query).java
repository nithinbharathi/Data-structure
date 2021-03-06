package sample;

public class codeforces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub'
		SegmentTree obj = new SegmentTree();
		int arr[] = new int[]{-1,2,4,0};	
		int segment_size = arr.length-1;
		obj.build(arr);
		System.out.println(obj.min_query(0, 2, 0, segment_size,0));
		

	}
}
class SegmentTree{
	int segment_tree[];
	public void build(int arr[]){
		segment_tree =new int[4*arr.length];
		construct_tree(arr,0,0,arr.length-1);
	}
	public void construct_tree(int arr[],int index,int start,int end){
		if(start == end){
			segment_tree[index] = arr[start]; 
			return;
		}
		int mid = (start+end)/2;
		construct_tree(arr,2*index+1,start,mid);
		construct_tree(arr,2*index+2,mid+1,end);
		segment_tree[index] = Math.min(segment_tree[2*index+1], segment_tree[2*index+2]);
	}
	
	public int min_query(int qs,int qe,int ss,int se,int index ){
		if(qs>se || qe<ss){
			return Integer.MAX_VALUE;
		}
		if(ss>=qs && se<=qe){
			return segment_tree[index];
		}
		int mid = (ss+se)/2;
		int l = min_query(qs,qe,ss,mid,2*index+1);
		int r = min_query(qs,qe,mid+1,se,2*index+2);
		return Math.min(l, r);
		
	}
	public void Display(){
		for(int n:segment_tree){
			System.out.print(n+" ");
		}
	}
	
}
