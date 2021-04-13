
import SwiftUI

struct ErrorView: View {

    typealias ErrorViewActionHandler = () -> Void

    let error: String
    let handler: ErrorViewActionHandler

    internal init(error: String, handler: @escaping ErrorView.ErrorViewActionHandler) {
        self.error = error
        self.handler = handler
    }

    var body: some View {
        VStack{
            Image(systemName: "exclamationmark.icloud.fill")
                .foregroundColor(.gray)
                .font(.system(size: 30, weight: .heavy))
                .padding(.bottom, 4)
            Text("Oops")
                .font(.system(size: 20, weight: .medium))
            Text(error)
                .foregroundColor(.gray)
                .font(.system(size: 15, weight: .medium))
                .padding(.bottom, 20)
            Button (action : {
                handler()
            },label :{Text("Retry")})
            .padding(12)
            .background(Color.blue)
            .foregroundColor(Color.white)
            .font(.system(size: 15, weight: .heavy))
            .cornerRadius(10.0)

        }
    }
}

struct ErrorView_Previews: PreviewProvider {
    static var previews: some View {
        ErrorView(error : "Error"){}
    }
}
