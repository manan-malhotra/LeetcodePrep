package Graphs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> adj = new ArrayList<>();
        build(adj);
        sc.close();
        bfs(adj);
        dfs(adj);
        
    }

    public static void dfs(List<List<Integer>> adj) {
        int[] vis = new int[adj.size()];
        List<Integer> dfs = new ArrayList<>();
        //vis[1]=1;
        //dfs.add(1);
        dfs(adj,1,dfs,vis);
        System.out.println(dfs);
    }

    
    private static void dfs(List<List<Integer>> adj, int i, List<Integer> dfs, int[] vis) {
        if(vis[i]==1) return;
        vis[i]=1;
        dfs.add(i);
        for(int j:adj.get(i)){
            dfs(adj, j, dfs, vis);
        }
    }

    public static void bfs(List<List<Integer>> adj) {
        int[] vis = new int[adj.size()];
        List<Integer> bfs = new ArrayList<>();
        vis[1]=1;
        bfs.add(1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i:adj.get(node)){
                if(vis[i]==0){
                    vis[i]=1;
                    bfs.add(i);
                    q.offer(i);
                }
            }
        }
        System.out.println(bfs);
    }
    public static void build(List<List<Integer>> adj){
         // int n = sc.nextInt();
        // int m = sc.nextInt();
        int n = 5; // Nodes
        int m = 8; // Edges
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        adj.get(1).add(2);
        adj.get(1).add(3);
      
        adj.get(4).add(5);
        adj.get(2).add(1);
        adj.get(3).add(1);
        adj.get(4).add(1);
        adj.get(3).add(5);
        adj.get(2).add(3);
        adj.get(5).add(2);
        adj.get(5).add(4);
        adj.get(1).add(4);
        adj.get(5).add(3);
        adj.get(3).add(2);
        adj.get(2).add(5);
        // for(int i=0;i<m;i++){
        //     int a = sc.nextInt();
        //     int b = sc.nextInt();
        //     adj.get(a).add(b);
        //     adj.get(b).add(a);
        // }
    }
    public static void print(List<List<Integer>> adj){
        for(List<Integer> i : adj){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}

