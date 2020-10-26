/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Leet341_FlattenNestedList{

}
public class NestedIterator implements Iterator<Integer> {
    
    ArrayList<Integer> result;
    Iterator it;
    public NestedIterator(List<NestedInteger> nestedList) {
        result = new ArrayList<Integer>();
        helper(nestedList, result);
        // System.out.println(result);
        it = result.iterator();
        
    }

    @Override
    public Integer next() {
        return (Integer)it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
    public void helper(List<NestedInteger> nestedList, ArrayList<Integer> result){
        for(int i=0; i<nestedList.size(); i++){
            if(nestedList.get(i).isInteger()){
                result.add(nestedList.get(i).getInteger());
            }else{
                helper(nestedList.get(i).getList(), result);
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
