"""
The program uses a Monte Carlo simulation to estimate the probability that more than 20% of the farmer's crop 
will be affected by pests. It does this by simulating the sampling process multiple times (10,000 simulations) and for 
each simulation, it randomly selects a sample of 1000 plants from the entire crop, calculates the proportion 
of affected plants in that sample, and records whether the proportion of affected plants in that sample is 
greater than 20%. After all the simulations are completed, it calculates the percentage of times that the proportion
of affected plants was greater than 20% and compares it to the actual proportion derived from the sample data.
"""
import random

def simulate_pest_effect(predicted_percentage_affected: float, number_of_plants_taken_on_each_simulation: int, total_number_of_plants: int, num_simulations: int, cutoff: float):
    """
    The function simulates the pest proportion of the plants by taking random samples of plants on each simulation.
    The function checks if the proportion of affected plants in the sample is greater than the cutoff (20%)
    The function returns the probability of pest proportion greater than the cutoff(20%)
    """
    # Initialize variables to store the number of simulations where pest proportion is greater than 20%
    # and the number of affected plants in each simulation
    
    greater_than_cutoff = 0
    affected_plants = 0

    for simulation_number in range(num_simulations):
        if simulation_number % 1000 == 0:
            print(f"Finished {simulation_number} Simulations")
        # Use random number generator to randomly select plants for the simulation
        plants_sample = random.sample(range(total_number_of_plants), number_of_plants_taken_on_each_simulation)
        affected_plants = sum([1 for i in plants_sample if i < predicted_percentage_affected*total_number_of_plants])
        # Check if proportion of affected plants in the sample is greater than the cutoff (20%)
        if affected_plants/number_of_plants_taken_on_each_simulation > cutoff:
            greater_than_cutoff += 1
    # Calculate the probability of pest proportion greater than the 20% by seeing the number of times the simulation ran above the cutoff
    probability = float(greater_than_cutoff)/float(num_simulations)
    return f"{probability:.2%}"

def main():
    """
    The main function runs the simulation, call the simulate_pest_effect function and prints the result
    """
    cutoff = 0.2 # %20 from the question
    predicted_percentage_affected = 0.22 # 22% infected from the farmer's first model
    number_of_plants_taken_on_each_simulation = 1000 #number of plants on each run
    total_number_of_plants = 10000 # number of plants in field we're just modelling a small portion
    number_of_simulations_to_run = 10000 # number of simulations to run
    probability = simulate_pest_effect(predicted_percentage_affected, number_of_plants_taken_on_each_simulation, total_number_of_plants, number_of_simulations_to_run, cutoff)
    print(f"Probability of pest proportion greater than 20%: {probability}")

if __name__ == '__main__':
    main()