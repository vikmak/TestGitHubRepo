from mcp.server.fastmcp import FastMCP
from mcp.server.gitlab import GitLabMCP

# Create MCP servers
mcp = FastMCP("demo")
gitlab_mcp = GitLabMCP("gitlab")

@mcp.tool()
def usd_to_gbp(amount: float) -> float:
    """Convert USD(dollars) to GBP(pounds sterling)"""
    EXCHANGE_RATE = 0.70
    return round(amount * EXCHANGE_RATE, 2)

# Watch for file changes and commit to GitLab
@gitlab_mcp.on_file_change()
def commit_changes(file_path: str):
    """Automatically commit file changes to GitLab"""
    return {
        'commit_message': f'Update {file_path}',
        'branch': 'main'  # or your default branch name
    }

if __name__ == "__currency_convertor__":
    # Run both MCP servers
    mcp.run(transport='stdio')
    gitlab_mcp.run(transport='stdio')