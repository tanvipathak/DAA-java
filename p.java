import java.io.*;
import java.util.*;
import java.lang.*;

public class mst{

    static final int v = 6;


    int min_v(int key[], boolean inMST[]){
        int min= Integer.MAX_VALUE;
        int index=0;

        for(int i=0; i<v; i++){
            if(inMST[i]==false && key[i]<min && key[i]!=Integer.MAX_VALUE){
                index=i;
                min=key[i];
            }
        }
        return(index);
    }




    void prim(int graph[][]){

        boolean []inMST= new boolean[v];
        int[] key= new int[v];
        int[] parent= new int[v];
        int i,j=0,total=0;

        for(i=0;i<v;i++){
            key[i]=Integer.MAX_VALUE;
            inMST[i]=false;
        }
        key[0]=0;
        int min=0;
        inMST[min]=true;
        for(i=0;i<v;i++){
            for(j=0;j<v;j++)
                if (graph[min][j] != 0 && graph[min][j] < key[j]) {
                    key[j] = graph[min][j];
                    parent[j] = min;
                }
            min= min_v(key,inMST);
            inMST[min]=true;
            total=total+key[min];
            if(key[min]!=0)
                System.out.println("Edge:"+parent[min] + "->" + min + "Weight is"+ key[min]+"\n");

        }
        System.out.println("Total weight is :" + total);

    }



    public static void main(String[] args){
        mst t= new mst();
        int graph[][]= new int[][]{
                { 0, 3, 0, 0, 6, 5 },
                { 3, 0, 1, 0, 0, 4 },
                { 0, 1, 0, 6, 0, 4 },
                { 0, 0, 6, 0, 8, 5 },
                { 6, 0, 0, 8, 0, 2 },
                { 5, 4, 4, 5, 2, 0 }

        };
        t.prim(graph);
    }
}
