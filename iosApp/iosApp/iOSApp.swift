import SwiftUI
import shared

@main
struct iOSApp: App {


    let getDog = GetDogs(recipeService: DogServiceImpl(), dtoMapper: DogDtoMapper())
    var body: some Scene {
        WindowGroup {
            ContentView(getDog: getDog)
        }
    }
}
