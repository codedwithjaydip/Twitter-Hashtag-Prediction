import pandas as pd

# Load CSV file
df = pd.read_csv("data/social_media_trends.csv")

# Display first 5 rows
print("First 5 rows:")
print(df.head())

# Display column names
print("\nColumn Names:")
print(df.columns)

# Display number of rows and columns
print("\nDataset Shape:")
print(df.shape)

# Display basic information
print("\nDataset Information:")
print(df.info())