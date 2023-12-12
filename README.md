# MuseumApp

Museum App is an Android application that allows users to explore and discover artworks from various collections.

## Prerequisites
- Android Studio 4.0 or later
- Android SDK with API level 29+
- Kotlin 1.5 or later
- Dagger Hilt 2.44
- Internet connection for API calls

## Getting Started

1. Clone this repository:

   ```bash
   git clone https://github.com/your-username/museum-app.git

## Features
- **Collection Screen**: View a list of artwork collections.
- **Artwork Screen**: Explore detailed information about individual artworks.
- **Navigation**: Navigate between screens using Jetpack Navigation.
- **Dependency Injection**: Utilizes Dagger Hilt for dependency injection.
- **Jetpack Compose**: UI components are built using Jetpack Compose.
- **Paging**: Paginates and displays collections using Paging 3.
- **Network Requests**: Fetches data from a remote API using Retrofit and Moshi.
- **Loading Indicators**: Shows loading indicators during data fetch.

## Architecture and Design
- This app follows the Model-View-ViewModel (MVVM) architectural pattern.
- Key components include:
- Models: Represent data structures and domain objects.
- Views: Display user interface elements using Jetpack Compose.
- ViewModels: Manage UI-related data and business logic.
- Repositories: Act as a single source of truth for data.

## Domain Models and Use Cases
- `Artwork`: Represents art data.
- `CollectionEntry`: Stores collection information.
- `GetArtwork`: Manages getting art data.
- `GetCollectionItemPagingDataFlow`: Handles getting collection data with paging.

## Data Sources
- This app fetches data from a RESTful API using Retrofit and Moshi.
- API base URL: `https://www.rijksmuseum.nl/api/nl`

## Dependency Injection
- Dagger Hilt is used for dependency injection.
- Module include `AppModule`

## Testing
- Unit tests: JUnit 4 and Mockito for testing individual functions and use cases.