package leetcode;

import javax.xml.bind.ValidationEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class day79单词搜索 {
    //    回溯或深度优先
    String myWord="";
    private boolean find=false;
    public boolean exist(char[][] board,String word){
        if (board == null) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){
                if(board[x][y]==word.charAt(0))  backtracking(board, word, x, y,visited);
            }
        }
        return find;
    }
    public void backtracking(char[][] board,String word,int x,int y,boolean[][] visited){
        // 超出边界、已经访问过、已找到目标单词、棋盘格中当前字符已经和目标字符不一致了
        int length = myWord.length();
        if(length >word.length()||!word.startsWith(myWord))
            return ;
/**  startsWith复杂度高，改成这种
        if(length!=0){
            if(length >word.length()||word.charAt(length-1)!=myWord.charAt(length-1))
                return ;
        }**/
        if(length ==word.length()&&myWord.equals(word))
        {find=true;return;}
        if(x<0 || x>= board.length || y<0 || y >= board[0].length||visited[x][y]==true)  return;
        if(!find){
            myWord=myWord+board[x][y];
            visited[x][y] = true;  // 修改当前节点状态
            backtracking(board, word ,x+1, y,visited);  // 遍历子节点
            backtracking(board, word ,x-1, y,visited);
            backtracking(board, word, x, y+1,visited);
            backtracking(board, word, x, y-1,visited);
            myWord=myWord.substring(0,myWord.length()-1);
            visited[x][y] = false; // 撤销修改
        }

    }


    public static void main(String[] args) {
        day79单词搜索 day79 = new day79单词搜索();
//        char[][] chars = {{'a', 'b', 'c', 'd'}, {'c', 'b', 'c', 'd'},{'c', 'b', 'c', 'd'}, {'c', 'b', 'c', 'd'}};
        char[][] chars = {{'a'}};
        boolean abc = day79.exist(chars, "a");
        System.out.println(abc);
    }

}
//class Solution {
//    private boolean find=false;
//    public boolean exist(char[][] board,String word){
//        if (board == null) return false;
//        boolean[][] visited = new boolean[board.length][board[0].length];
//        for(int x=0;x<board.length;x++){
//            for(int y=0;y<board[0].length;y++){
//                if(board[x][y]==word.charAt(0))  backtracking(board, word, x, y,visited,0);
//            }
//        }
//        return find;
//    }
//    public void backtracking(char[][] board,String word,int x,int y,boolean[][] visited,int i){
//        // 超出边界、已经访问过、已找到目标单词、棋盘格中当前字符已经和目标字符不一致了
//        if(x<0 || x>= board.length || y<0 || y >= board[0].length||visited[x][y]==true||board[x][y] != word.charAt(i))
//            return ;
//        if(i == word.length() - 1)
//        {find=true;return;}
//
//        visited[x][y] = true;  // 修改当前节点状态
//        backtracking(board, word ,x+1, y,visited,i+1);  // 遍历子节点
//        backtracking(board, word ,x-1, y,visited,i+1);
//        backtracking(board, word, x, y+1,visited,i+1);
//        backtracking(board, word, x, y-1,visited,i+1);
//        visited[x][y] = false; // 撤销修改
//    }
//
//
//}