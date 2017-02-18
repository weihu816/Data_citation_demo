package citation_view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class citation_view_vector {
	
	public Vector<citation_view> c_vec;
	
	public ArrayList<String> index_vec;
	
	public HashSet<String> view_strs;
	
	public citation_view_vector()
	{
		c_vec = new Vector<citation_view>();
		
		index_vec = new ArrayList<String>();
		
		view_strs = new HashSet<String>();
		
	}
	
	public citation_view_vector(Vector<citation_view> vec){
		
		c_vec = vec;
		
		index_vec = new ArrayList<String>();
		
		view_strs = new HashSet<String>();
		
		for(int i = 0; i<c_vec.size(); i++)
		{
			
			view_strs.add(vec.get(i).toString());
			
			index_vec.add(c_vec.get(i).get_index());
//			
//			Tuple tuple = Gen_citation2.map.get(c_vec.get(i).get_name());
//			
//			for(Iterator iter = tuple.core.iterator();iter.hasNext();)
//			{
//				String core_name = iter.next().toString();
//				
//				tuple_cores.add(core_name);
//			}
			
			
		}
		
	}
	
	public citation_view_vector(Vector<citation_view> vec, ArrayList<String> index_vec, HashSet<String> tuple_cores){
		
		this.c_vec = vec;
		
		this.index_vec = index_vec;
		
		this.view_strs = tuple_cores;
		
	}
	
	public citation_view_vector(citation_view c){
		
		c_vec = new Vector<citation_view>();
		
		c_vec.add(c);
		
		index_vec = new ArrayList<String>();
		
		view_strs = new HashSet<String>();
		
		view_strs.add(c.toString());
		
		index_vec.add(c.get_index());
		
//		for(int i = 0; i<c_vec.size(); i++)
//		{
//			
//			view_strs.add(c)
//			index_vec.add(c_vec.get(i).get_index());
//			
//			Tuple tuple = Gen_citation2.map.get(c_vec.get(i).get_name());
//			
//			for(Iterator iter = tuple.core.iterator();iter.hasNext();)
//			{
//				String core_name = iter.next().toString();
//				
//				view_strs.add(core_name);
//			}
			
			
//		}
		
	}
	
	
	public static citation_view_vector merge(citation_view_vector vec, citation_view c)
	{
		
		if(vec.view_strs.contains(c.toString()))
		{
			return vec;
		}
		else
			return merge_vector(new citation_view_vector(c), vec);
		
		
//		citation_view_vector insert_vec = new citation_view_vector(c);
//		
//		if(vec.tuple_cores.containsAll(insert_vec.tuple_cores))
//		{
//			return vec;
//		}
//		else
//		{
//			if(insert_vec.tuple_cores.containsAll(vec.tuple_cores))
//			{
//				return insert_vec;
//			}
//			else
//			{
//				return merge_vector(insert_vec, vec);
//			}
//		}
	}
	
	static citation_view_vector merge_vector(citation_view_vector vec1, citation_view_vector vec2)
	{
		Vector<citation_view> vec_new = (Vector<citation_view>) vec1.c_vec.clone();
		
		vec_new.addAll((vec2.c_vec));
		
		ArrayList<String> index_new = (ArrayList<String>) vec1.index_vec.clone();
		
		index_new.addAll(vec2.index_vec);
		
		HashSet<String> tuple_cores_new = (HashSet<String>) vec1.view_strs.clone();
		
		tuple_cores_new.addAll(vec2.view_strs);
		
		return new citation_view_vector(vec_new, index_new, tuple_cores_new);
		
		
	}
	
	@Override
	public String toString()
	{
		String str = new String();
		
		for(int i = 0; i<c_vec.size(); i++)
		{
			
			if(i >= 1)
				str += "*";
			str += c_vec.get(i).toString();
		}
		
		return str;
	}
	
	public static void main(String [] args)
	{
		Vector<Character> c_vec = new Vector<Character>();
		
		Vector<Character> vec = new Vector<Character>();
		
		
		c_vec.add('c');
		
		c_vec.add('a');
		
		c_vec.add('b');
		
		vec.add('b');
		
		vec.add('c');
		
		if(c_vec.containsAll(vec))
		{
			int y = 0; 
			y++;
		}
		
	}
	
	public citation_view_vector clone()
	{
		citation_view_vector c_v = new citation_view_vector();
		
		for(int i = 0; i<this.c_vec.size(); i++)
		{
			c_v.c_vec.add(c_vec.get(i).clone());
		}
		
		for(int i = 0; i<this.index_vec.size(); i++)
		{
			c_v.index_vec.add(index_vec.get(i));
		}
		
		c_v.view_strs.addAll(view_strs);
		
		
		return c_v;
		
		
		
	}

}
