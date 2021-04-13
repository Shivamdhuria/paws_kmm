import SwiftUI
import URLImage
import shared

struct DogItemView: View {

    let dog : Dog

    var body: some View {
        HStack{
            Spacer()
            VStack(){
                if let url = URL(string: dog.imageUrl){
                    URLImage(url: url,
                             options: URLImageOptions(
                                identifier: imageUrl,
                                expireAfter: nil,
                                cachePolicy: .returnCacheElseLoad(cacheDelay: nil, downloadDelay: nil)
                             ),
                             content: { image in
                                image
                                    .resizable()
                                    .scaledToFill()
                                    .clipped()
                             })
                        .frame(width: 300, height: 300, alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/)
                        .cornerRadius(30.0)

                }

                let breedName = dog.breedName

                Text(breedName)
                    .foregroundColor(Color.gray)
                    .font(.system(size: 24, weight: .heavy))
                    .frame(width: .infinity, alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/)
                    .lineLimit(1)

            } .cornerRadius(30.0)
            Spacer()
        }
    }
}
