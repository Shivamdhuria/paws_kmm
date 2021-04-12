//
//  UsersViewmodel.swift
//  paws
//
//  Created by Shivam Dhuria on 10/04/21.
//

import Foundation
import Combine
import shared

class DogListViewModel: ObservableObject {
    
    let getDogs : GetDogs
    
    //injecting Use case
    init(getDogs: GetDogs) {
        self.getDogs = getDogs
    }
    
    @Published private(set) var state: ResultState = .loading
    
    // The Recipes
    @Published var recipes: [Dog] = []
    
    
    
    @Published var loading = false
    
    func loadDogs() {
        
        do{
            try getDogs.execute().watch(block: {dataState in
                if dataState != nil {
                    let _data = dataState?.data
                    let _error = dataState?.error
                    let _loading = dataState?.loading ?? false
                    
                    self.loading = _loading
                    if(_data != nil){
                        self.appendRecipes(recipes: _data as! [Dog])
                        self.state = .success
                    }
                    if(_error != nil){
                        self.state = .failed(error: _error!)
                    }
                }else{
                    
                }
            })
        }catch{
            
            
        }
        
    }
    private func appendRecipes(recipes: [Dog]){
        self.recipes.append(contentsOf: recipes)
    }
}

//    @Published private(set) var state: ResultState = .loading

//    func getDogs() {
//        self.state = .loading
//        let cancellable = service
//            .request(from: .getUsers)
//            .sink{res in
//                switch res {
//
//                case .finished:
//                    self.state = .success(content: self.dogUrls)
//                    break
//
//                case .failure(let error):
//                    self.state = .failed(error: error)
//                    break
//                }
//            }
//            receiveValue: { users in
//                let oldData = self.dogUrls
//                self.dogUrls = oldData + users.message
////                self.dogUrls = users.message
//            }
//        //To keep hold of the request
//        self.cancellables.insert(cancellable)
//    }



//    init() {
//        setUpPublisher()
//    }
//private var anyCancellable: AnyCancellable?

//    private func setUpPublisher(){
//        let url = URL(string: "https://jsonplaceholder.typicode.com/users")!
//        anyCancellable =  URLSession.shared.dataTaskPublisher(for: url)
//            .tryMap{(data,response) in
//                guard let httpResponse = response as? HTTPURLResponse,
//                      httpResponse.statusCode == 200 else {
//                    throw URLError(.badServerResponse)
//                }
//                return data
//            }
//            .decode(type: [User].self, decoder: JSONDecoder())
//            .receive(on: DispatchQueue.main)
//            .sink(receiveCompletion: {_ in }){users in
//                self.users = users
//            }
//
//    }
//}

//extension BreweriesViewModel {
//    enum State {
//        case idle
//        case loading
//        case loaded([User])
//        case error(Error)
//    }
//
//    enum Event {
//        case onAppear
//        case onSelectMovie(Int)
//        case onMoviesLoaded([User])
//        case onFailedToLoadMovies(Error)
//    }
//}




enum ResultState {
    case loading
    case success
    case failed(error:String)
}
