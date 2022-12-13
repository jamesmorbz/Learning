#define	Tiny	0
#define T3		1
#define FedEx	2

#include <stdio.h>
#include <math.h>

Elapsed_Mins += *Mins + (*Hrs * 60);	// Calculate from midnight today
Mins = Elapsed_Mins % 60;
Hrs = (Elapsed_Mins % (24 * 60)) / 60;
Days = Elapsed_Mins / (24 * 60);
    if Mins > 0) or Mins < 29
	    Mins = 30
    elif Mins > 30: 
	    Mins = 0;
	    Hrs += 1;
	    if Hrs >= 24) {
		    *Hrs = 0;
		    *Days += 1;
	return;

// Calculate and return the total time for Tiny to transport data
// update Days:Hrs:Mins with expected arrival time
int Calc_Tiny(int Size, int Dist, int *Days, int *Hrs, int *Mins)
{
	int Total_Trips = 0;
	int Trip_Time = 0;
	int Total_Time = 0;

	if (Dist > 3000)	// Tiny can't swim across the ocean!
		return 0;
										// 600000 is Tiny's carrying capacity
	Total_Trips = ceil ((float)Size / (3 * 200 * 1000));	
										// ceil is for partial capacity trips
	if (Total_Trips > 1)				// calculate return trips too
		Total_Trips += (Total_Trips -1);
	Trip_Time = Dist * 15;				// 4 mph is a 15 minute mile

	Total_Time = Total_Trips * Trip_Time;

	//printf("Tiny One-Way Trips :%d\n", Total_Trips);
	//printf("Tiny Trip Time : %d\n", Trip_Time);
	//printf("Tiny Total Time : %d\n", Total_Time);
	Calc_Time(Days, Hrs, Mins, Total_Time);
	return Total_Time;
}

// Calculate and return the total time for the T3 line to transport data
// update Days:Hrs:Mins with expected completion time
int Calc_T3(int Size, int *Days, int *Hrs, int *Mins)
{
	int Total_Time = 0;

	// Mins    =       (MBytes * (Bits/Byte))/(Mbits/sec * sec/Min)
	Total_Time = ceil (((float)Size   *     8      )/(    45    *   60   ));

	Calc_Time(Days, Hrs, Mins, Total_Time);
	return Total_Time;
}

// Calculate and return the total time for the FedEx to transport data
// update Days:Hrs:Mins with expected completion time
int Calc_FedEx(int Size, int *Days, int *Hrs, int *Mins)
{
	int Total_Time = 0;
	// Did we make today's delivery?
	if (*Hrs <= 18)
		*Days = 1;	// Delivery scheduled for tomorrow
	else
		*Days = 2;	// Pick-up will not be until tomorrow, so delivery day after

	Total_Time = (10 * 60) + 30;	// 10:30 delivery time
	Total_Time += (24 - *Hrs) * 60;	// How long until midnight tonight?
	Total_Time += (*Days - 1) * (24 * 60);	// Did we sit for a full day waiting for pickup?

	Calc_Time(Days, Hrs, Mins, Total_Time);
	return Total_Time;
}

int main (int argc, char* argv[])
{
	int Size;
	int Distance;
	int Hr_Ready;
	int Time[3];
	int Days[3];
	int Hrs[3];
	int Mins[3];
	char Methods[3][6] = {"Tiny", "T3", "FedEx"};
	int method_choice;
	char Input[20];

	// Get input from user
	printf("Enter size of transfer in megabytes: ");
	scanf("%s",Input);
	Size = atoi(Input);
	printf("Enter distance to the destination in miles: ");
	scanf("%s",Input);
	Distance = atoi(Input);
	printf("Enter time data will be ready to send as HHMM: ");
	scanf("%s",Input);
	Input[2] = '\0';	// Read out the hour, assume all data will be ready to send at the top of the hour
	Hr_Ready = atoi(Input);	 

	// Preload Transfer Start time into Data into arrays for calculations
	Days[0] = Days[1] = Days[2] = 0;
	Hrs[0] = Hrs[1] = Hrs[2] = Hr_Ready;
	Mins[0] = Mins[1] = Mins[2] = 0;
	
	// Calculate transfer time by each method
	Time[Tiny] = Calc_Tiny(Size, Distance, &Days[Tiny], &Hrs[Tiny], &Mins[Tiny]);
	Time[T3] = Calc_T3(Size, &Days[T3], &Hrs[T3], &Mins[T3]);
	Time[FedEx] = Calc_FedEx(Size, &Days[FedEx], &Hrs[FedEx], &Mins[FedEx]);

	// Compare and determine best transfer method
	if (Time[FedEx] < Time[T3])
		method_choice  = FedEx;
	else
		method_choice = T3;
	if ((Time[Tiny] > 0) && (Time[Tiny] < Time[T3]) && (Time[Tiny] < Time[FedEx]))
		method_choice = Tiny;

	// Debug Print
	int x;	
	for (x=0; x < 3; x++)
		printf ("Method:%10s, transfer: %6d Arrival:%02d%02d day %d\n", Methods[x],Time[x],Hrs[x],Mins[x],Days[x]);

	// Print results
	printf("Shipment by %s will arrive at %02d%02d hours ", Methods[method_choice], Hrs[method_choice], Mins[method_choice]);
	switch (Days[method_choice]) {
		case 0:		printf("today\n");
					break;
		case 1:		printf("tomorrow\n");
					break;
		default:	printf("%d days from today\n", Days[method_choice]);
					break;

	}
}
