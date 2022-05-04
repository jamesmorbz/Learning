import pandas as pd
import numpy as np
import math
import random
import pdb
import csv
import matplotlib.pyplot as plt
# Stress = Force / Area

'''
Finding Average of Inital Diameters

High Carbon Steel - 9.93 9.93 9.92
Low Carbon Steel - 9.93 9.93 9.92
Aluminium 9.93 9.94 9.93

'''

'''
Finding Average of Inital Diameters

Cast Iron - 5.94 5.94 5.93
Low Carbon Steel - 5.93 5.94 5.93
Aluminium - 5.93 5.95 5.95
'''


'''
Young's Modulus Values

High Carbon Steel - 0.00100
Low Carbon Steel - 0.00100
Aluminium - 0.00250

'''

def calculating_initial_radius(x):
    sum = 0
    for i in x:
        sum += i
    average_diameter = sum / 3
    radius = average_diameter / 2
    
    return radius
    
def calculate_area(radius):
    area = (radius**2) * (math.pi)
    return area

def calculating_engineering_stress(force, area):
    stress = force / area
    return stress

def calculating_polar_moment_of_inertia(radius):
    j = ((math.pi)*(radius**4)) / 2
    return j

def processing_dataframe(dataframe, area):
    list_of_stresses = []
    for force in dataframe["Force"]: 
        stress = calculating_engineering_stress(force, area)
        list_of_stresses.append(stress)

    list_of_strains = []
    for strain in dataframe["TensileStrain"]:
        strain = strain / 100
        list_of_strains.append(strain)
    
    return list_of_stresses, list_of_strains
    
def plot_graph(y_values, x_values, graph_title):
    plt.rcParams.update(  # Updating Parameters of the Graph to look better
        {
            "font.size": 10,
            "xtick.major.size": 4,
            "xtick.major.width": 1,
            "ytick.major.size": 4,
            "ytick.major.width": 1,
        }
    )
    plt.plot(x_values, y_values) # Plot a Graph of Value X against Value Y
    plt.xlabel("Strain") # Creating Label for X axis
    plt.ylabel("Stress") # Creating Label for Y axis
    plt.title(graph_title)
    plt.grid(axis="both") # Creates grid in x + y direction - Can change to axis="y" or axis="x"
    plt.show() # Render Plot to Screen

def read_in_dataframe(filepath):
    pd.set_option('mode.chained_assignment',None)
    dataframe = pd.read_csv(filepath)

    return dataframe

def get_modulus_values(stress, strain, lower_bound, upper_bound, material_name):
    lower_bound_index = 0
    upper_bound_index = 0

    for index, value in enumerate(stress):
        if value > lower_bound:
            lower_bound_index = index
            break

    for index, value in enumerate(stress):
        if value > upper_bound:
            upper_bound_index = index
            break
    
    if lower_bound_index == upper_bound_index:
        lower_bound_index = lower_bound_index - 1 
        upper_bound_index = upper_bound_index + 1

    new_stress = stress[lower_bound_index:upper_bound_index]
    new_strain = strain[lower_bound_index:upper_bound_index]
    
    plot_graph(new_stress, new_strain, material_name)
    gradient_calculation(new_stress, new_strain, material_name)

def gradient_calculation(new_stress, new_strain, material):
    first_stress = new_stress[0]
    first_strain = new_strain[0]
    last_stress = new_stress[-1]
    last_strain = new_strain[-1]

    stress_diff = last_stress - first_stress
    strain_diff = last_strain - first_strain

    gradient =  stress_diff / strain_diff

    print(f"Gradient - {material} - {gradient}")

def tension_test(INITIAL_DIAMETERS, HCS_FILEPATH, LOWERBOUND, UPPERBOUND, MATERIAL):
    ultimate_tensile_strength = 0
    failure_strain = 0
    radius = calculating_initial_radius(INITIAL_DIAMETERS)
    area = calculate_area(radius)
    dataframe_hcs = read_in_dataframe(HCS_FILEPATH)
    stress, strain = processing_dataframe(dataframe_hcs, area)
    plot_graph(stress, strain, MATERIAL)
    get_modulus_values(stress, strain, LOWERBOUND, UPPERBOUND, MATERIAL)
    for value in stress:
        if value > ultimate_tensile_strength:
            ultimate_tensile_strength = value
    
    for value in strain:
        if value > failure_strain:
            failure_strain = value
    
    print(f"Ultimate Tensile Strength of {MATERIAL} = {ultimate_tensile_strength}")
    print(f"Failure Strain of {MATERIAL} = {failure_strain}")
    print("------------")

def torsion_test(initial_diameter, filepath, length, upper_bound, lower_bound, material_name):
    list_of_shear_stress_values = []
    list_of_shear_strain_values = []
    radius = calculating_initial_radius(initial_diameter)
    J = calculating_polar_moment_of_inertia(radius)
    constant = radius / J
    dataframe = read_in_dataframe(filepath)
    for torque in dataframe["Torque"]:
        torque = torque * constant
        list_of_shear_stress_values.append(torque)
    for angle in dataframe["Angle"]:
        radians = angle * (math.pi/180)
        shear_strain = radians * (radius / length)
        list_of_shear_strain_values.append(shear_strain)
    plot_graph(list_of_shear_stress_values, list_of_shear_strain_values, "Shear Stress vs Shear Strain")
    get_modulus_values(list_of_shear_stress_values, list_of_shear_strain_values, lower_bound, upper_bound, material_name)

HCS_MATERIAL = "High Carbon Steel"
HCS_FILEPATH = "E:\Coding\Learning\BristolUniTerm2\CBWTest_1_HC_steel.csv"
HCS = [9.93, 9.93, 9.92]
HIGHCARBONUPPER = 0.00110
HIGHCARBONLOWER = 0.00090

LCS_MATERIAL = "Low Carbon Steel"
LCS_FILEPATH = "E:\Coding\Learning\BristolUniTerm2\CBWTest_2_LC_steel.csv"
LCS = [9.93, 9.93, 9.92]
LOWCARBONUPPER = 0.00100
LOWCARBONLOWER = 0.00100

ALU_MATERIAL = "Aluminium"
ALU_FILEPATH = "E:\Coding\Learning\BristolUniTerm2\CBWTest_3_Ali.csv"
ALU = [9.93, 9.94, 9.93]
ALUMINIUMUPPER= 0.00250
ALUMINIUMLOWER = 0.00250

ALU_TORQUE_FILEPATH = "E:\Coding\Learning\BristolUniTerm2\TorAl.csv"
FE_TORQUE_FILEPATH = "E:\Coding\Learning\BristolUniTerm2\TorFe.csv"
LCS_TORQUE_FILEPATH = "E:\Coding\Learning\BristolUniTerm2\TorLCS.csv"

ALU_MATERIAL = "Aluminium"
ALU_DIAMETER = [5.94, 5.94, 5.93]
ALU_LENGTH = 76.8
ALU_UPPER_BOUND = 0.03
ALU_LOWER_BOUND = 0

FE_MATERIAL = "Cast Iron"
FE_DIAMETER = [5.93, 5.94, 5.93]
FE_LENGTH = 75.85
FE_UPPER_BOUND = 0.25
FE_LOWER_BOUND = 0

LCS_MATERIAL = "Low Carbon Steel"
LCS_DIAMETER = [5.93, 5.95, 5.95]
LCS_LENGTH = 76.7
LCS_UPPER_BOUND = 0.011
LCS_LOWER_BOUND = 0


def main():
    tension_test(HCS, HCS_FILEPATH, HIGHCARBONLOWER, HIGHCARBONUPPER, HCS_MATERIAL)
    tension_test(LCS, LCS_FILEPATH, LOWCARBONLOWER, LOWCARBONUPPER, LCS_MATERIAL)
    tension_test(ALU, ALU_FILEPATH, ALUMINIUMLOWER, ALUMINIUMUPPER, ALU_MATERIAL)

    torsion_test(ALU_DIAMETER, ALU_TORQUE_FILEPATH, ALU_LENGTH, ALU_UPPER_BOUND, ALU_LOWER_BOUND, ALU_MATERIAL)
    torsion_test(FE_DIAMETER, FE_TORQUE_FILEPATH, FE_LENGTH, FE_UPPER_BOUND, FE_LOWER_BOUND, FE_MATERIAL)
    torsion_test(LCS_DIAMETER, LCS_TORQUE_FILEPATH, LCS_LENGTH, LCS_UPPER_BOUND, LCS_LOWER_BOUND, LCS_MATERIAL)

    
if __name__ == '__main__':
    main()