import django
import requests

def main():
    good_response = requests.get("http://google.com")
    bad_response = requests.get("http://google.com/thisIsNotFound")
    
    print(f"Bad response => {bad_response.status_code}")
    print(f"Good response => {good_response.status_code}")
    
if __name__ == "__main__":
    main()