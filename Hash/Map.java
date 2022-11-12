package com.project.Hash;

import java.nio.channels.FileChannel;
import java.util.ArrayList;

//Implemantation
public class Map<K,V> {
    //we can't make array of generic type so use list
  //  MapNode<K,V>[]bucket;
    ArrayList<MapNode<K,V>>buckets;
 int size;//n no of entries
    int numBuckets;
    public Map(){
        numBuckets=5;
        buckets=new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }
    public int getBucketIndex(K key){
        int hashCode=key.hashCode();// hashCode has been implemented in Object Class//its combo of address//we can modify it
        return hashCode%numBuckets;
    }
    public void insert(K key,V value){
        int bucketIndex=getBucketIndex(key);
        MapNode<K,V>head=buckets.get(bucketIndex);
        while (head!=null){
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head=head.next;
        }
        head=buckets.get(bucketIndex);
        MapNode<K,V>newElementNode=new MapNode<K,V>(key,value);
        size++;
        newElementNode.next=head;
        buckets.set(bucketIndex,newElementNode);
        double loadFactor=(1.0*size)/numBuckets;   //n/b
        if(loadFactor>0.7)
            rehash();
    }

    private void rehash() {
        System.out.println("rehashing:buckets "+numBuckets+" size "+size);
        ArrayList<MapNode<K,V>>temp=buckets;
        buckets=new ArrayList<>();
        for (int i = 0; i <2*numBuckets ; i++) {
            buckets.add(null);
        }
        size=0;
        numBuckets*=2;
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K,V>head=temp.get(i);
            while (head!=null){
              K  key=head.key;
               V value= head.value;
               insert(key,value);
               head=head.next;
            }
        }
    }
    public double loadFactor(){
        return (1.0*size)/numBuckets;
    }

    public  V search(K key) {
        // search value corresponding to key and return value//getValue
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
               return head.value ;
            }
            head = head.next;
        }
        return null;
    }

    public  V removeKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev=null;
        while (head != null) {
            if (head.key.equals(key)) {
                size--;
                if (prev==null){
                    buckets.set(bucketIndex,head.next);
                }else
                    prev.next=head.next;
                return head.value ;
            }
            prev=head;
            head = head.next;

        }
        return null;
    }
    public  int size(){
        return size;
    }

    public static void main(String[] args) {
        Map<String,Integer>map=new Map<>();
        for (int i = 0; i < 20; i++) {
            map.insert("abc"+i,1+i);
            System.out.println("i= "+i+" if="+map.loadFactor());

        }
        //System.out.println("abc"+5);
        map.removeKey("abc3");
        for (int i = 0; i < 20; i++) {
            System.out.println("abc"+i+":"+map.search("abc"+i));
        }
    }

}

