//LargestNumber.cpp
#include "gtest/gtest.h"
#include "../../Sample1/Source/Largest.cpp"


class LargestNumber :public testing::Test {
public:
	Largest *lg;
	LargestNumber(){}
	virtual ~LargestNumber(){}

	virtual void SetUp(){
		lg = new Largest();
	}
	virtual void TearDown(){
		delete lg;
	}

};

TEST_F(LargestNumber, test1){
	std::vector<int> list = { 7, 8, 9 };
	EXPECT_EQ(9, lg->getLargest(list));
}




//ExampleBeforeAfterTest.cpp
#include <iostream>
#include <gtest/gtest.h>

class ExampleBeforeAfterTest :public testing::Test{
protected:
	ExampleBeforeAfterTest(){}
	virtual ~ExampleBeforeAfterTest(){}
	virtual void SetUp(){
		std::cout << "Before Test" << std::endl;
	}
	virtual void TearDown(){
		std::cout << "After Test" << std::endl;
	}
};

TEST_F(ExampleBeforeAfterTest, test1){
	std::cout << "Test1 Runs" << std::endl;
}
TEST_F(ExampleBeforeAfterTest, test2){
	std::cout << "Test2 Runs" << std::endl;
}


//CalculateTest.cpp
#include "gtest/gtest.h"
#include "../../Sample1/Source/Calculate.cpp"

TEST(CalculateTest, plus){
	Calculate cal = Calculate();
	EXPECT_EQ(5, cal.sum(2, 3));
	EXPECT_EQ(5, cal.sum(0, 5));
	EXPECT_EQ(5, cal.sum(6, -1));
}

TEST(CalculateTest, subtract){
	Calculate cal = Calculate();
	EXPECT_EQ(7, cal.subtract(6, -1));
	//EXPECT_GT(3, cal.subtract(5, 1));
}


//Calculate.cpp
class Calculate {
public:
	Calculate(){}
	~Calculate(){}

	int sum(int var1, int var2){
		return var1 + var2;
	}

	int subtract(int var1, int var2){
		return var1 - var2;
	}
};

//Largest.cpp
#include <iostream>
#include <vector>

class Largest {
public:
	Largest(){}
	~Largest(){}

	int getLargest(std::vector<int> list){
		int index, max = INT_MIN;
		for (index = 0; index < list.size() ; index++){
			if (list[index] > max)
				max = list[index];
		}
		return max;
	}

};

//main.cpp
#include "gtest/gtest.h"

int main(int argc, char* argv[]){
	::testing::InitGoogleTest(&argc, argv);
	return RUN_ALL_TESTS();
}
