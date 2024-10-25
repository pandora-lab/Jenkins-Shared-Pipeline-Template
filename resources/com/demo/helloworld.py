import argparse

# Create the parser
parser = argparse.ArgumentParser(description='Process name and place.')

# Add arguments
parser.add_argument('--name', type=str, required=True, help='Name of the person')
parser.add_argument('--place', type=str, required=True, help='Place name')

# Parse the arguments
args = parser.parse_args()

# Print the values
print(f'Name: {args.name}')
print(f'Place: {args.place}')

    
