
# 📦 SimpleDB

[![GitHub Pages](https://img.shields.io/badge/GitHub%20Pages-Live-brightgreen)](https://dryfish09.github.io/SimpleDB/)
[![License: AGPL](https://img.shields.io/badge/License-AGPL-blue.svg)](LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/dryfish09/SimpleDB)](https://github.com/dryfish09/SimpleDB/stargazers)

A lightweight, no-database file archive system hosted on GitHub Pages. SimpleDB provides permanent, publicly accessible URLs for your files with zero configuration.

## ✨ Features

- 📁 **Simple File Hosting** - Upload files to `/files/` directory and they're instantly available
- 🔗 **Permanent URLs** - Every file gets a clean, permanent URL
- ⚡ **GitHub Pages Powered** - No servers, no databases, no maintenance
- 📊 **Live File Listing** - Automatically displays first 10 files from your repository
- 💾 **Smart Caching** - 30-minute cache to minimize API calls
- 🔄 **Manual Refresh** - Update file list with one click
- 📱 **Responsive Design** - Works on all devices
- 🎨 **Clean UI** - Modern, readable interface
- ♿ **Accessible** - ARIA labels and semantic HTML

## 🚀 Quick Start

### 1. Fork/Clone the Repository

```bash
git clone https://github.com/dryfish09/SimpleDB.git
cd SimpleDB
```

### 2. Add Your Files

Place any files in the `files/` directory:

```
simpledb/
├── index.html
├── README.md
├── _config.yml
└── files/
    ├── your-file.pdf
    ├── image.jpg
    └── data.csv
```

### 3. Commit and Push

```bash
git add .
git commit -m "Add files to SimpleDB"
git push origin main
```

### 4. Access Your Files

Your files are now available at:
```
https://dryfish09.github.io/SimpleDB/files/your-file.pdf
```

## 📁 File Structure

```
SimpleDB/
├── index.html          # Main page with file listing
├── README.md           # This documentation
├── _config.yml         # GitHub Pages configuration
├── .nojekyll           # Disables Jekyll processing
└── files/              # Directory for your files
    └── (your files here)
```

## 🔗 URL Structure

| Resource | URL |
|----------|-----|
| Main Page | `https://dryfish09.github.io/SimpleDB/` |
| File Access | `https://dryfish09.github.io/SimpleDB/files/filename.ext` |
| GitHub Repo | `https://github.com/dryfish09/SimpleDB` |

## 🛠️ How It Works

1. **File Storage**: Files are stored in the `files/` directory of the GitHub repository
2. **File Listing**: Uses GitHub API to fetch and display the first 10 files
3. **Caching**: Data is cached in `localStorage` for 30 minutes to reduce API calls
4. **Direct Access**: Files are served directly via GitHub Pages CDN

### API Usage

The page makes two GitHub API calls:
- `GET /repos/dryfish09/SimpleDB/contents/files` - Lists files
- `GET /repos/dryfish09/SimpleDB/commits?path=files` - Gets commit dates

**Rate Limits**: 60 unauthenticated requests per hour. Caching helps stay within limits.

## 📝 Adding Files

### Option 1: GitHub Web Interface
1. Navigate to the `files/` directory in your repository
2. Click "Add file" → "Upload files"
3. Select your files and commit

### Option 2: Git Command Line
```bash
# Add a file
cp /path/to/your/file.pdf files/
git add files/file.pdf
git commit -m "Add file.pdf"
git push

# Add multiple files
cp *.pdf files/
git add files/
git commit -m "Add multiple files"
git push
```

### Option 3: GitHub CLI
```bash
gh repo clone dryfish09/SimpleDB
cd SimpleDB
cp /path/to/file.pdf files/
gh add files/file.pdf
gh commit -m "Add file.pdf"
gh push
```

## ⚙️ Configuration

### `_config.yml`
```yaml
title: SimpleDB
description: Lightweight File Archive
baseurl: "/SimpleDB"
url: "https://dryfish09.github.io"
```

### `CACHE_DURATION` (in index.html)
```javascript
const CACHE_DURATION = 30 * 60 * 1000; // 30 minutes
```
Adjust this value to change how long data is cached.

## 🌐 Live Demo

Visit the live site: [https://dryfish09.github.io/SimpleDB/](https://dryfish09.github.io/SimpleDB/)

## 🔧 Customization

### Changing the Owner/Repo

Update these variables in `index.html`:
```javascript
const USERNAME = 'dryfish09';  // Your GitHub username
const REPO = 'SimpleDB';       // Your repository name
const FILES_PATH = 'files';    // Directory containing files
```

### Styling

Modify the CSS in the `<style>` section of `index.html` to match your branding.

### File Icons

Add or modify file icon mappings:
```javascript
const FILE_ICONS = {
    'pdf': '📄',
    'doc': '📝',
    // Add your own mappings
};
```

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Development Setup

```bash
# Clone your fork
git clone https://github.com/your-username/SimpleDB.git
cd SimpleDB

# Make changes
# Test locally by opening index.html in a browser
# Or use a local server:
python3 -m http.server 8000
# Visit http://localhost:8000
```

## 📊 Performance

- **First Load**: ~500ms (API calls)
- **Cached Load**: ~50ms (localStorage)
- **File Size**: ~15KB (HTML/CSS/JS)
- **API Calls**: 2 per refresh (or 60/hour max)

## 🔒 Security

- Files are publicly accessible via their URLs
- No authentication required (intentional for simplicity)
- All files are served over HTTPS
- No data is stored server-side (everything is static)

## 📋 Requirements

- GitHub account
- Git (for command-line usage)
- Web browser (Chrome, Firefox, Safari, Edge)

## 🐛 Known Issues

- **Rate Limiting**: 60 unauthenticated API requests per hour
  - *Mitigation: 30-minute caching*
- **Large Files**: GitHub has a 100MB file limit
  - *Use Git LFS for larger files*
- **Special Characters**: Some filenames may need URL encoding
  - *Handled automatically by the page*

## 🚦 Status

- ✅ File listing
- ✅ Direct downloads
- ✅ Smart caching
- ✅ Rate limit handling
- ✅ Responsive design
- ✅ Accessibility
- ✅ Error handling
- ✅ Auto-refresh

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- [GitHub Pages](https://pages.github.com/) for hosting
- [GitHub API](https://docs.github.com/en/rest) for file listing
- All contributors and users of SimpleDB

## 📧 Contact

- GitHub: [@dryfish09](https://github.com/dryfish09)
- Project Link: [https://github.com/dryfish09/SimpleDB](https://github.com/dryfish09/SimpleDB)

---

<div align="center">
Made with ❤️ by <a href="https://github.com/dryfish09">dryfish09</a>
</div>
