#include <stdio.h>
#include <stdlib.h>




int main (int argc, char *argv[])
{
      /*INPUT CHECKS*/
	int day=0;
	int year=0;
	int ret=0;

	if((argc !=4)){
		fprintf(stderr,"Input not valid\n");
		return 0;
	}

	ret = sscanf(argv[2], "%d",&day);
	if(ret!=1){
		fprintf(stderr,"Input not valid\n");
		return 0;
	}
	ret = sscanf(argv[3], "%d",&year);
	if(ret!=1){
		fprintf(stderr,"Input not valid\n");
		return 0;
	}

	if((day<1)||(day>31)){
		fprintf(stderr,"Input not valid\n");
		return 0;
	}

	if((year<1901)||(year>2038)){
		fprintf(stderr,"Input not valid\n");
		return 0;
	}




	/*Check days is valid with Month and Year*/




	char *m = argv[1];


   /* local variable definition
    char *m = "Feb";
    int day =20;
    int year =1994; */
    int numMonth;
    numMonth = getMonth(m);
    if(numMonth==0){
	return 0;
    }

    int monthsC[12]={31,28,31,30,31,30,31,31,30,31,30,31};
	if(isLeap(year)==1){
		monthsC[1]=monthsC[1]+1;
	}

	if(day>monthsC[numMonth-1]){
		fprintf(stderr,"Input not valid\n");
		return 0;
	}








    /*printf( "Value of Month : %d\n", numMonth);*/
    int yearsodd;
    yearsodd=calcyearodd(year);
    /*printf( "Odd Days for year : %d\n", yearsodd);*/

    int daymonodd;
    daymonodd=calcdateodd(year,day,numMonth);
    /*printf("Odd Days for days : %d\n", daymonodd);*/

	int daynum = (yearsodd+daymonodd)%7;
	char *days[7] = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
	if(daynum==0){
		daynum=7;
	}
	printf("%s\n",(days[daynum-1]));




   return 0;
}
int calcyearodd(int inputyear){
    int yearmin = inputyear-1;
	int count =0;
	int yearsleft=0;

	if(yearmin>=1600){
		yearsleft= yearmin-(yearmin/400)*400;
	}
	if(yearsleft>=300){
		count+=(yearsleft/300);
		yearsleft= yearsleft-(yearsleft/300)*300;
	}
	if(yearsleft>=200){
		count+=(yearsleft/200)*3;
		yearsleft= yearsleft-(yearsleft/200)*200;
	}
	if(yearsleft>=100){
		count+=(yearsleft/100)*5;
		yearsleft= yearsleft-(yearsleft/100)*100;
	}

	if(yearsleft<100){

		int leaps = yearsleft/4;
		int norm = yearsleft-leaps;

		int leapsdays = (leaps*2)%7;
		int normdays = (norm)%7;
		count+=leapsdays+normdays;
	}

	return count;

}
int calcdateodd(int yearin,int dayin,int monin) {
    int months[12]={31,28,31,30,31,30,31,31,30,31,30,31};
	if(isLeap(yearin)==1){
		months[1]=months[1]+1;
	}

	int countmonthodds=0;
	int i=0;
	for(i=0;i<monin-1;i++){
		countmonthodds+=months[i]%7;
	}
	int countdaysodds=dayin%7;

	return (countdaysodds+countmonthodds)%7;

}

int isLeap(int yearl){
	if (yearl % 4 != 0) {
    return 0;
  } else if (yearl % 400 == 0) {
    return 1;
  } else if (yearl % 100 == 0) {
    return 0;
  } else {
    return 1;
  }
}


/* function returning the max between two numbers */
int getMonth(char *input)
{
   /* local variable declaration */
    int result;

    char *jan="Jan";
    char *feb="Feb";
    char *mar="Mar";
    char *apr="Apr";
    char *may = "May";
    char *jun="Jun";
    char *jul="Jul";
    char *aug="Aug";
    char *sep = "Sep";
    char *oct="Oct";
    char *nov="Nov";
    char *dec = "Dec";

    if (strcmp(input,jan) == 0){
        result=1;
    }
    else if (strcmp(input,feb) == 0){
        result=2;
    }
    else if (strcmp(input,mar) == 0){
        result=3;
    }
    else if (strcmp(input,apr) == 0){
        result=4;
    }
    else if (strcmp(input,may) == 0){
        result=5;
    }
    else if (strcmp(input,jun) == 0){
        result=6;
    }
    else if (strcmp(input,jul) == 0){
        result=7;
    }
    else if (strcmp(input,aug) == 0){
        result=8;
    }
    else if (strcmp(input,sep) == 0){
        result=9;
    }

    else if (strcmp(input,oct) == 0){
        result=10;
    }
    else if (strcmp(input,nov) == 0){
        result=11;
    }
    else if (strcmp(input,dec) == 0){
        result=12;
    }
    else{
        fprintf(stderr,"Input not valid\n");
        result=0;

    }

return result;
    }
