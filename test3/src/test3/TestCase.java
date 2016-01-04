package test3;

import java.util.List;

public interface TestCase {
	public Object run(List<Object> params) throws Exception;  
	   public List<Object> getParams();  
	   public void printResult(Object result);
}
