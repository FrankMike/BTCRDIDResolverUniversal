//
//  ContentView.swift
//  BTCRDIDResolver
//
//  Created by Francesco Micheli on 03/03/22.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack(spacing: 10,content: {  //SwiftUI experiment
            Spacer()
            Text("BTCR DID Resolver")
                .foregroundColor(Color.orange)
                .padding()
            Spacer()
            TextField("BTCR DID", text: )
                .padding(.horizontal, 20.0)
            Spacer()
        })
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
