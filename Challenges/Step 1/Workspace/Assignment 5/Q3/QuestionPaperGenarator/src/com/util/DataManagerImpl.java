package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bean.Category;
import com.bean.Complexity;
import com.bean.Criteria;
import com.bean.Question;

// Override and implement all the methods of DataManager Interface here
public class DataManagerImpl implements DataManager
{

	@Override
	public List<Question> populateData() 
	{
		List<Question> list= new ArrayList<Question>();
		
		try
		{
			DatabaseConnectionManager dbcm = new DatabaseConnectionManager();
			Connection dbcon = dbcm.getConnection();
			Statement stmt = dbcon.createStatement();
			String query = "select * from questionBank";
			ResultSet result = stmt.executeQuery(query);
			
			while(result.next())
			{
				Question ques = new Question();
				ques.setSrno(result.getInt("SrNo"));
				ques.setQuestion(result.getString("Question"));
				ques.setOption1(result.getString("optionA"));
				ques.setOption2(result.getString("optionB"));
				ques.setOption3(result.getString("optionC"));
				ques.setOption4(result.getString("OptionD"));
				ques.setCorrectAns(result.getString("CorrectAns"));
				ques.setComplexity(Complexity.valueOf(result.getString("Complexity")));
				ques.setType(Category.valueOf(result.getString("Category")));

				list.add(ques);
			}
			dbcm.closeConnection();

		}
		catch(SQLException e)
		{
			System.out.println("SQLException occured!!");
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Class not found!!");
			e.printStackTrace();
		}
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list;
		}
	}

	@Override
	public List<Question> getQuestionByCategory(Category category,
			List<Question> questionsList) 
	{
		List<Question> found = new ArrayList<Question>();
		
		for(Question ques : questionsList)
		{
			if(ques.getCategory() == category)
			{
				found.add(ques);
			}
		}
		if(found.isEmpty())
		{
			return null;
		}
		else
		{
			return found;
		}
	}

	@Override
	public List<Question> getQuestionByComplexity(Complexity complexity,
			List<Question> questionsList) 
	{
List<Question> found = new ArrayList<Question>();
		
		for(Question ques : questionsList)
		{
			if(ques.getComplexity() == complexity)
			{
				found.add(ques);
			}
		}
		if(found.isEmpty())
		{
			return null;
		}
		else
		{
			return found;
		}
	}

	@Override
	public Set<Question> generateQuestionPaper(List<Question> list,
			List<Criteria> template) 
	{
		Set<Question> set = new HashSet<Question>();
		List<Question> matched = new ArrayList<Question>();
		
		for(Criteria criteria : template)
		{
			matched = getQuestionByComplexity(criteria.getComplexity(), 
					getQuestionByCategory(criteria.getCategory(), list));
			int size = matched.size();
			
			if(size<=criteria.getNoOfQuestion())
			{
				for(Question ques : matched)
					set.add(ques);
			}
			else
			{
				int i=0;
				while(i<criteria.getNoOfQuestion())
				{  
					int c = (int)(Math.random() * size);
					if(!set.contains(matched.get(c)))
					{
						set.add(matched.get(c));
						i++;
					}
				}
			}
		}
		if(set.isEmpty())
		{
			return null;
		}
		else
		{
			return set;
		}
	}

	@Override
	public void sortByCategory(List<Question> questionList) 
	{
		Collections.sort(questionList, new Comparator()
				{

					@Override
					public int compare(Object o1, Object o2) 
					{
						Category x1 = ((Question) o1).getCategory();
						Category x2 = ((Question) o2).getCategory();
						return x1.compareTo(x2);

					}
			
				});
	}

	@Override
	public void sortByComplexity(List<Question> questionList) 
	{
		Collections.sort(questionList, new Comparator()
		{

			@Override
			public int compare(Object o1, Object o2) 
			{
				Complexity x1 = ((Question) o1).getComplexity();
				Complexity x2 = ((Question) o2).getComplexity();
				return x1.compareTo(x2);

			}
	
		});		
	}


}