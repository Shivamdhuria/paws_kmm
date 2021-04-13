import SwiftUI
import shared

struct ContentView: View {
    
    @ObservedObject var viewModel: DogListViewModel
    
    init(getDog : GetDogs) {
        viewModel = DogListViewModel(getDogs: getDog)
    }
    
    
    
    var body: some View {
        
        VStack{
            NavigationView {
                List(viewModel.dogs, id: \.self) { dog in
                    DogItemView(dog: dog).padding(.bottom, 20)
                }.navigationBarTitle("Dogs")
                
            }
            switch viewModel.state {
            case .loading: ProgressView()
            case .failed(let errorMessage):ErrorView(error: errorMessage, handler: viewModel.loadDogs)
            case .success:
                    Spacer()
                    Button (action : viewModel.loadDogs ,labelDogI :{Text("Load more ")})

            }
        }.onAppear(perform: viewModel.loadDogs)
    }
    
    
}

//struct ContentView_Previews: PreviewProvider {
//    static var previews: some View {
//        ContentView()
//    }
//}
