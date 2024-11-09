import java.util.*;
public class bellman{

    public static int[] bellmanford(int V,int [][]edge,int src){
        int dist[]=new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;

        for(int i=0;i<V;i++){
            for(int j=0;j<edge.length;j++){
                int u=edge[j][0],v=edge[j][1],wt=edge[j][2];

                if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                    if(i==V-1){
                        //negative weighted cycle
                        return new int[]{-1};
                    }
                    dist[v]=dist[u]+wt;
                }
            }
        }
        return dist;
    }
    public static void main(String[] args){
        int v;int src;
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        v=sc.nextInt();
        System.out.println("Enter the number of edges:");
        int e=sc.nextInt();
        int[][] edge=new int[e][3];
        for(int i=0;i<e;i++){
            System.out.println("for"+i+"th edge:");
            System.out.println("Enter the u vertex:");
            edge[i][0]=sc.nextInt();
            System.out.println("Enter the v vertex:");
            edge[i][1]=sc.nextInt();
            System.out.println("Enter the weight of the edge:");
            edge[i][2]=sc.nextInt();
        }

        System.out.println("Enter the source vertex:");
        src=sc.nextInt();
        int ans[]=bellmanford(v,edge,src);

        System.out.print("ANSWER:");
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
