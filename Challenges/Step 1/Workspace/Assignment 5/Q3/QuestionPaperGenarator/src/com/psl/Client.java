package com.psl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bean.Category;
import com.bean.Complexity;
import com.bean.Criteria;
import com.bean.Question;
import com.util.DataManagerImpl;

public class Client 
{
	public static void main(String[] args) 
	{
		List<Question> list= new ArrayList<Question>();
		//List<Question> found= new ArrayList<Question>();
		Set<Question> set = new HashSet<Question>();
		
		List<Criteria> template = new ArrayList<Criteria>();
		template.add(new Criteria(Category.GK, Complexity.Simple, 2));
		template.add(new Criteria(Category.GK, Complexity.Medium, 1));
		template.add(new Criteria(Category.GK, Complexity.Complex, 1));
		template.add(new Criteria(Category.Science, Complexity.Complex, 1));
		template.add(new Criteria(Category.History, Complexity.Medium, 2));
		template.add(new Criteria(Category.History, Complexity.Simple, 2));
		template.add(new Criteria(Category.Geography, Complexity.Medium, 1));
		
		DataManagerImpl test = new DataManagerImpl();
		
		list = test.populateData();
		
		//found = test.getQuestionByComplexity(Complexity.Medium, list);
		
		//test.sortByComplexity(list);
		
		set = test.generateQuestionPaper(list, template);
		
		for(Question ques : set)
		{
			System.out.println(String.valueOf(ques.getSrno()) + ques.getComplexity() + ques.getCategory());
		}
		
		
	}
}
