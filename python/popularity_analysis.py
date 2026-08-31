import pandas as pd

# Load dataset
df = pd.read_csv("data/social_media_trends.csv")

# Calculate popularity score
df["Popularity_Score"] = df["Likes"] + df["Retweets"]

# Display hashtag and popularity
print("\nHashtag Popularity:")
print(df[["Hashtag", "Likes", "Retweets", "Popularity_Score"]])

# Find most popular hashtag
most_popular = df.loc[df["Popularity_Score"].idxmax()]

print("\nMost Popular Hashtag:")
print(most_popular["Hashtag"])

print("\nPopularity Score:")
print(most_popular["Popularity_Score"])