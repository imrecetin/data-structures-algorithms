package com.problems.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrderWithDFS(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(root, lists, 0);
        return lists;
    }

    static void helper(TreeNode root, List<List<Integer>> lists, int level){
        if(root == null) { return ;}

        List<Integer> list = null;

        if(lists.size() > level){
            list = lists.get(level);
        }else{
            list = new ArrayList<>();
            lists.add(list);
        }

        list.add(root.val);
        helper(root.left, lists, level+1);
        helper(root.right, lists, level+1);
    }

    public List<List<Integer>> levelOrderwithBFS(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) {return lists; }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int qsize = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i=0; i<qsize; i++){
                TreeNode child = q.poll();
                temp.add(child.val);
                if(child.left != null){
                    q.offer(child.left);
                }
                if(child.right != null){
                    q.offer(child.right);
                }
            }
            lists.add(temp);
        }
        return lists;
    }
}
