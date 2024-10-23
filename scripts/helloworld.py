import sys

def main():
    if len(sys.argv) < 2:
        print("Please provide a name.")
        sys.exit(1)

    # Get the name from the command-line arguments
    name = sys.argv[1]

    # Use the supplied argument
    print(f"Hello, {name}!")

if __name__ == "__main__":
    main()
