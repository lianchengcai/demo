package Test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.fjnu.dao.DeptDao;
import cn.edu.fjnu.dao.IManagerDao;
import cn.edu.fjnu.dao.IntypeDao;
import cn.edu.fjnu.dao.ItemsortDao;
import cn.edu.fjnu.dao.OuttypeDao;
import cn.edu.fjnu.dao.SuptypeDao;
import cn.edu.fjnu.entity.Dept;
import cn.edu.fjnu.entity.Employee;
import cn.edu.fjnu.entity.Inquiry;
import cn.edu.fjnu.entity.Intype;
import cn.edu.fjnu.entity.Items;
import cn.edu.fjnu.entity.Itemsort;
import cn.edu.fjnu.entity.Manager;
import cn.edu.fjnu.entity.Outstock;
import cn.edu.fjnu.entity.Outtype;
import cn.edu.fjnu.entity.PageResult;
import cn.edu.fjnu.entity.Supplier;
import cn.edu.fjnu.entity.Suptype;
import cn.edu.fjnu.service.ItemsortService;
import junit.framework.TestCase;
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration(locations={"classpath*:springmvc.xml","classpath*:applicationContext.xml","classpath*:applicationContext-shiro.xml"})
@ActiveProfiles("production")
public class Testaa extends TestCase {
	
	@Autowired
	private SuptypeDao suptypeDao;
	
	@Autowired
	private DeptDao deptDao;
	
	@Autowired
	private IntypeDao intypeDao;
	
	@Autowired
	private OuttypeDao outtypeDao;
	
	@Autowired
	private ItemsortDao itemsortDao;
	
	@Autowired
	private ItemsortService service;
	
	@Resource
	private IManagerDao managerDao;

	
	@Test
	public void queryByPage() throws Exception{
	     PageResult<Items>  pagedResult = service.queryByPage(2,10);//null表示查全部    
	     System.out.println(pagedResult);
	}
	
	//添加物品
	@Test
	public void testAddItems() throws Exception{
		Items items=new Items();
		for(int i=123;i<333;i++){
			items.setNumber("items_"+i);
			items.setName("苹果手机_"+i);
			items.setSort("电子产品");
			items.setModel("6sPlus");
			items.setPiece("台");
			items.setPrice(5250);
			items.setTotalNum(15);
			items.setTotalMoney(78750);
			items.setHigher(30);
			items.setLower(10);
			items.setSup("苹果公司");
			items.setNote("苹果6sPlus手机");
			itemsortDao.addItems(items);
		}
	}
	
	//添加物品类型
	@Test
	public void testAddItemsort() throws Exception{
		Itemsort itemsort=new Itemsort();
		for(int i=1;i<253;i++){
			itemsort.setItemsortNumber("itemsort_"+i);
			itemsort.setItemsortName("电子产品");
			itemsort.setNote("物品类型备注");
			itemsortDao.addItemsort(itemsort);
		}
	}
	
	//添加供应商类型
	@Test
	public void testAddSuptype() throws Exception{
		Suptype suptype=new Suptype();
		for(int i=1;i<183;i++){
			suptype.setSuptypeNumber("suptype_"+i);
			suptype.setSuptypeName("手机供应商");
			suptype.setNote("供应商类型备注");
			suptypeDao.addSuptype(suptype);
		}
	}
	
	//添加供应商
	@Test
	public void testAddSupplier() throws Exception{
		Supplier supplier=new Supplier();
		for(int i=1;i<246;i++){
			supplier.setNumber("supplier_"+i);
			supplier.setFullName("美国苹果公司");
			supplier.setSimName("苹果公司");
			supplier.setType("手机供应商");
			supplier.setContact("奥巴马");
			supplier.setFax("传真");
			supplier.setPost("邮编");
			supplier.setPhone("10010");
			supplier.setAddress("美国旧金山");
			supplier.setNote("供应商备注");
			suptypeDao.addSupplier(supplier);
		}
	}
	
	//添加部门
	@Test
	public void testAddDept() throws Exception{
		Dept dept=new Dept();
		for(int i=1;i<163;i++){
			dept.setDeptNumber("deptNumber_"+i);
			dept.setDeptName("销售部_"+i);
			dept.setNote("部门备注");
			deptDao.addDept(dept);
		}
	}
	
	//添加员工
	@Test
	public void testAddEmployee() throws Exception{
		Employee employee=new Employee();
		for(int i=1;i<186;i++){
			employee.setNumber("empNumber_"+i);
			employee.setName("empName_"+i);
			employee.setDept("销售部_"+i);
			employee.setAddress("福州");
			employee.setBirthday("1990-1-1");
			employee.setBirthplace("福建省");
			employee.setCardID("350783");
			employee.setDegree("博士");
			employee.setEmail("123@qq.com");
			employee.setJob("java程序员");
			employee.setPhone("10086");
			employee.setSchool("福师大");
			employee.setSex(i%2==0?"男":"女");
			employee.setTelephone("1388888888");
			employee.setNote("员工");
			deptDao.addEmployee(employee);
		}
	}

	//添加入库类型
	@Test
	public void testAddIntype() throws Exception{
		Intype intype=new Intype();
		for(int i=1;i<268;i++){
			intype.setIntypeNumber("intypeNumber_"+i);
			intype.setIntypeName("盒装入库_"+i);
			intype.setNote("入库类型备注");
			intypeDao.addIntype(intype);
		}
	}
	
	//添加入库信息
	@Test
	public void testAddInquiry() throws Exception{
		Inquiry inquiry=new Inquiry();
		for(int i=1;i<365;i++){
			inquiry.setNumber("inquiry_"+i);
			inquiry.setDate(new Date());
			inquiry.setItems("苹果手机_"+i);
			inquiry.setType("盒装入库_"+i);
			inquiry.setTrustee("经办人");
			inquiry.setOperator("操作人");
			inquiry.setSup("供应商");
			inquiry.setSumNum(1);
			inquiry.setSumMoney(5250);
			inquiry.setNote("入库备注");
			intypeDao.addInquiry(inquiry);
		}
	}
	
	//添加出库类型
	@Test
	public void testAddOuttype() throws Exception{
		Outtype outtype= new Outtype();
		for(int i=1;i<250;i++){
			outtype.setOuttypeNumber("outtypeNumber_"+i);
			outtype.setOuttypeName("搬运出库_"+i);
			outtype.setNote("出库类型备注");
			outtypeDao.addOuttype(outtype);
		}
	}
	
	//添加出库信息
	@Test
	public void testAddOutstock() throws Exception{
		Outstock outstock=new Outstock();
		for(int i=1;i<168;i++){
			outstock.setNumber("outstock_"+i);
			outstock.setType("搬运出库_"+i);
			outstock.setDate(new Date());
			outstock.setDept("领用部门");
			outstock.setReceiver("领用人");
			outstock.setItems("苹果手机_"+i);
			outstock.setOperator("操作人");
			outstock.setSumNum(2);
			outstock.setSumMoney(10500);
			outstock.setNote("出库备注");
			outtypeDao.addOutstock(outstock);
		}
	}
	
	@Test
	public void testAddOut1stock() throws Exception{
		Manager aa = managerDao.getManagerById("110");
		System.out.println(aa);
	}
	

	

}
