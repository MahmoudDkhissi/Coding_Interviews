package com.mdk.trees;


import java.util.Stack;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {}

      TreeNode(int val) { this.val = val; }

      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

      public int maxDepthRecursive(TreeNode root) {
          if (root==null) {
              return 0;
          }
          return 1+Math.max(maxDepthRecursive(root.left),maxDepthRecursive(root.right));
      }

      public int maxDepthIterative(TreeNode root) {
          if (root==null) {
              return 0;
          }
          Stack<TreeNode> stack = new Stack<>();
          Stack<Integer> depths = new Stack<>();
          stack.push(root);
          depths.push(1);
          int maxDepth = 0;
          while (!stack.isEmpty()) {
              TreeNode node = stack.pop();
              int depth = depths.pop();
              maxDepth = Math.max(maxDepth,depth);
              if (node.left!=null) {
                  stack.push(node.left);
                  depths.push(depth+1);
              }
              if (node.right!=null) {
                  stack.push(node.right);
                  depths.push(depth+1);
              }
          }
          return maxDepth;
      }

    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p==null && q==null) {
            return true;
        }
        else if (p== null && q!=null) {
            return false;
        }
        else if (p!=null && q==null) {
            return false;
        }
        else {
            return p.val==q.val && isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
        }
    }

  }

