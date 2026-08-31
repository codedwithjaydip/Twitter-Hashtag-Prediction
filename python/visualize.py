import pandas as pd
import matplotlib.pyplot as plt

# Load dataset
df = pd.read_csv("data/social_media_trends.csv")

# Calculate popularity score
df["Popularity_Score"] = df["Likes"] + df["Retweets"]

# Sort hashtags by popularity
df = df.sort_values("Popularity_Score", ascending=False)

# Create bar chart
plt.figure(figsize=(10, 6))

plt.bar(df["Hashtag"], df["Popularity_Score"])

plt.xlabel("Hashtag")
plt.ylabel("Popularity Score")
plt.title("Twitter Hashtag Popularity")

plt.xticks(rotation=45)
plt.tight_layout()

# Save graph
plt.savefig("visualization/hashtag_popularity.png")

# Display graph
plt.show()