# Task Manager - Android App

A modern Android task management app built with Kotlin and Jetpack Compose. Features Material Design 3, Room database for offline storage, category filtering, priority levels, and smooth animations.

## Features

- **Add Tasks** - Create tasks with title, description, priority, and category
- **Priority Levels** - High, Medium, Low with color-coded indicators
- **Categories** - Organize tasks by custom categories with filter chips
- **Mark Complete** - Toggle tasks between pending and completed
- **Offline Storage** - Room database for persistent local storage
- **Material Design 3** - Modern UI with dynamic color theming
- **Swipe Actions** - Delete tasks with swipe gestures
- **Clean Architecture** - MVVM pattern with Repository layer

## Tech Stack

- **Language:** Kotlin
- **UI:** Jetpack Compose + Material 3
- **Database:** Room (SQLite)
- **Architecture:** MVVM
- **State Management:** StateFlow + Compose State
- **Build:** Gradle (Kotlin DSL)

## Architecture

```
app/src/main/java/com/taskmanager/app/
├── data/
│   ├── local/
│   │   ├── TaskDao.kt          # Room DAO with Flow queries
│   │   └── TaskDatabase.kt     # Room database singleton
│   ├── model/
│   │   └── Task.kt             # Task entity with Priority enum
│   └── repository/
│       └── TaskRepository.kt   # Data access layer
├── ui/
│   ├── components/
│   │   ├── TaskItem.kt         # Individual task card component
│   │   └── AddTaskDialog.kt    # Add task dialog
│   ├── screens/
│   │   ├── TaskListScreen.kt   # Main screen with task list
│   │   └── TaskViewModel.kt    # ViewModel with UI state
│   └── theme/
│       └── Theme.kt            # Material 3 theme config
└── MainActivity.kt             # Entry point
```

## Getting Started

### Prerequisites

- Android Studio Hedgehog or newer
- Android SDK 26+
- Kotlin 2.1+

### Installation

```bash
# Clone the repository
git clone https://github.com/saif-ullah-k/task-manager-android.git

# Open in Android Studio
# File -> Open -> Select the project folder

# Build and run on emulator or device
```

### Build

```bash
./gradlew assembleDebug
```

## Screenshots

| Task List | Add Task | Categories |
|-----------|----------|------------|
| Main screen with pending & completed sections | Dialog to create new task | Filter by category chips |

## License

MIT
