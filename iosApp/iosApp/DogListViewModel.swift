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
    @Published var dogs: [Dog] = []

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
        self.dogs.append(contentsOf: recipes)
    }
}

enum ResultState {
    case loading
    case success
    case failed(error:String)
}
