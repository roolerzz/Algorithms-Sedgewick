package com.algorithms.string.processing;

public class KMPNFA {

	  /*  public int strStr(String haystack, String needle) {
	        if(haystack == null || needle == null)
	            return -1;
	        else if (needle.length()==0)
	            return 0;
	        else if (haystack.length() == 0 || (haystack.length() < needle.length()))
	            return -1;
	        int hl = haystack.length(), nl = needle.length();
	    int j;int i;
	        for(i=0,j=0 ; i < hl && j< nl; i++){
	                if(haystack.charAt(i) == needle.charAt(j))
	                    j++;
	                    else{
	                        i-=j; j=0;    
	                    }
	        }
	        if(j==nl)
	                return i-nl;
	        return -1;
	    }*/
	    
	    // Behold KMP implementation ahead.
	    public int strStr(String haystack, String needle) {
	        if(haystack == null || needle == null)
	            return -1;
	        else if (needle.length()==0)
	            return 0;
	        else if (haystack.length() == 0 || (haystack.length() < needle.length()))
	            return -1;
	        haystack=haystack.toLowerCase();
	        needle = needle.toLowerCase();
	        /*int hl = haystack.length(), nl = needle.length();
	        int[][] dfa = constructDFA(needle);
	        int j;int i;
	        for(i=0,j=0 ; i < hl && j< nl; i++){
	                j=dfa[haystack.charAt(i)-'a'][j];
	        }
	        if(j==nl)
	                return i-nl;*/
	        return KMPNFA(haystack.toCharArray(),needle.toCharArray());
	        //return -1;
	    }
	    
	    private int[][] constructDFA(String needle){
	        int patLen = needle.length();
	        int[][] dfa = new int[26][patLen];
	        dfa[needle.charAt(0)-'a'][0] = 1;
	        for(int X = 0, j=1; j<patLen; j++){
	            for(int c=0; c<26 ; c++)
	                dfa[c][j]=dfa[c][X];
	            dfa[needle.charAt(j)-'a'][j] = j+1;
	            X = dfa[needle.charAt(j)-'a'][X];
	        }
	        return dfa;
	    }
	    // NFA implementation of KMP algorithm. Builds the array for mismatch transactions.
	    private int[] computeTemporaryArray(char[] pattern){
	        // Calculates the length of the longest prefix which is also a suffix.
	        int[] lps = new int[pattern.length];
	        int index = 0;
	        int i;
	        for(i=1; i<pattern.length;){
	            if(pattern[i]==pattern[index]){
	                lps[i]=index+1;
	                i++;
	                index++;
	            }
	            else{
	                if(index!=0){
	                    index=lps[index-1];
	                }
	                else{
	                    lps[i]=0;
	                    i++;
	                }
	            }
	        }
	        return lps;
	    }
	    
	    public int KMPNFA(char[] text, char[] pat){
	        int[] lps = computeTemporaryArray(pat);
	        int i=0;
	        int j=0;
	        while(i<text.length && j<pat.length){
	            if(text[i] == pat[j]){
	                i++;
	                j++;
	            }
	            else{
	                if(j!=0)
	                    j=lps[j-1];
	                else
	                    i++;
	            }
	        }
	         if(j == pat.length)
	            return i-pat.length;
	        return -1;
	    }
	    } 
