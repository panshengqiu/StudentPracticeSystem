package cn.edu.bjut.practice;

import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.manageridentified.mapper.ManagerIdentifiedMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PracticeApplicationTests {

	@Autowired
	private ManagerIdentifiedMapper managerIdentifiedMapper;
	@Test
	void contextLoads() {
	}

	@Test
	public void sqlTest(){
		String name = "阿里巴巴";
		Enterprise enterprise = new Enterprise(1,name,null,null,null,null,null);
		List<Enterprise> enterprises = managerIdentifiedMapper.selectPendingFirmOnNameAndCreditCode(enterprise);

	}

}
